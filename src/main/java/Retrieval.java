package main.java;

import main.java.filter.IFilter;
import main.java.filter.QueryFilter;
import main.java.filter.SGMLFilter;
import main.java.indexing.SPIMI;
import main.java.io.FileHandler;
import main.java.model.Document;
import main.java.model.PostingFileItem;
import main.java.nlp.Tokenizer;
import main.java.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Retrieval {

    private Map<String, LinkedList<PostingFileItem>> corpusIndex = null;
    private Map<String, LinkedList<PostingFileItem>> queryIndex = null;
    private double avgCorpusDocLen = 0.0, avgQueryDocLen = 0.0;
    private Map<String, String> queries;
    private IFilter filter;
    private HashSet<String> stopWords;

    private final byte W1_WEIGHING_SCHEME = 0;
    private final byte W2_WEIGHING_SCHEME = 1;

    public Retrieval() {
        this.filter = new QueryFilter();
    }

    public void loadQueries(String queryFilePath) {
        filter.construct();
        FileHandler handler = new FileHandler(queryFilePath, filter);
        Map<String, String> contents = handler.read();
        queries = new LinkedHashMap<>();
        for(String key: contents.keySet()) {
            for(String line: contents.get(key).split("Q")) {
                if(!line.trim().isEmpty()) {
                    String[] lineSplit = line.split(": ");
                    queries.put(lineSplit[0], lineSplit[1]);
                }
            }
        }
    }

    public void loadStopwords(String stopWordsFilePath) {
        stopWords = new HashSet<>(1);
        try {
            File file = new File(stopWordsFilePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                stopWords.add(line.toLowerCase().trim());
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<Short, Map<Short, Double>> getCosineSimilarity(Document[] queryArray, Document[] documents, byte weighingScheme) {
        Map<Short, Map<Short, Double>> queryCosineScores = new LinkedHashMap<>();
        for(Document query: queryArray) {
            if(weighingScheme == W1_WEIGHING_SCHEME) {
                query.generateW1Vector((short) queryArray.length, queryIndex);
            }
            else {
                query.generateW2Vector(avgQueryDocLen, (short) queryArray.length, queryIndex);
            }
        }
        for (Document document: documents) {
            if(weighingScheme == W1_WEIGHING_SCHEME) {
                document.generateW1Vector((short) documents.length, corpusIndex);
            }
            else {
                document.generateW2Vector(avgCorpusDocLen, (short) documents.length, corpusIndex);
            }
        }
        for (Document query: queryArray) {
            queryCosineScores.put(query.getId(), new LinkedHashMap<>());
            for(Document document: documents) {
                queryCosineScores.get(query.getId()).put(document.getId(), Utils.computeDotProduct(query.getVector(), document.getVector()));
            }
            queryCosineScores.put(query.getId(), sortDocumentsByCosineScore(queryCosineScores.get(query.getId())));
        }
        return queryCosineScores;
    }

    private Map<Short, Double> sortDocumentsByCosineScore(Map<Short, Double> documents) {
        return documents.entrySet()
                .stream()
                .sorted(Map.Entry.<Short, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    private double computeAvgDocLen(Document[] documents) {
        double doclen = 0;
        for(Document document: documents) {
            doclen += document.getLength();
        }
        return doclen / documents.length;
    }

    public static void prettyPrintQDDetails(Map<Short, Map<Short, Double>> queryDocumentCosineScores, Document[] queryDocuments, Document[] corpusDocuments, Map<String, String> documentHeadlinesMap) {
        for(Short queryId: queryDocumentCosineScores.keySet()) {
            Map<Short, Double> documentCosineScores = queryDocumentCosineScores.get((queryId));
            Utils.prettyPrintDocumentVector("Query", queryDocuments[queryId]);
            int counter = 0;
            System.out.format("%s%10s%30s%10s%n", "Rank", "Score", "External Doc Identifier", "Headline");
            System.out.format("%s%n", "-------------------------------------------------------------------");
            for(short documentId: documentCosineScores.keySet()) {
                Document document = corpusDocuments[documentId];
                Utils.printDocOverview(document, counter + 1, documentCosineScores.get(documentId), documentHeadlinesMap.get(document.getName()));
                counter++;
                if(counter == 5) break;
            }
            counter = 0;
            for(short documentId: documentCosineScores.keySet()) {
                System.out.println();
                Utils.prettyPrintDocumentVector("Document", corpusDocuments[documentId]);
                counter++;
                if(counter == 5) break;
            }
            System.out.format("%s%n", "------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        if(args.length != 3 || args[0].isEmpty()) {
            System.out.println("Error: Invalid number of arguments found!");
            System.out.println("Expected:");
            System.out.println("java Retrieval <corpus_dir_path> <queries_filepath> <stopwords_filepath>");
            System.exit(0);
        }

        Retrieval retrieval = new Retrieval();
        retrieval.loadQueries(args[1]);
        retrieval.loadStopwords(args[2]);

        Tokenizer corpusTokenizer = new Tokenizer(Tokenizer.LEMMA_TOKENS, retrieval.stopWords, new SGMLFilter());
        corpusTokenizer.tokenize(args[0], corpusTokenizer.getFilter(), true);
        SPIMI corpusIndexer = new SPIMI();
        corpusIndexer.createIndex(corpusTokenizer.getTokenMap(), "");
        retrieval.corpusIndex = corpusIndexer.getIndex();

        Tokenizer tokenizer = new Tokenizer(Tokenizer.LEMMA_TOKENS, retrieval.stopWords, new QueryFilter());
        tokenizer.tokenize(retrieval.queries);
        SPIMI queryIndexer = new SPIMI();
        queryIndexer.createIndex(tokenizer.getTokenMap(), "");
        retrieval.queryIndex = queryIndexer.getIndex();

        Document[] corpusDocuments = corpusIndexer.getDocuments();
        Document[] queryDocuments = queryIndexer.getDocuments();

        FileHandler handler = new FileHandler(args[0]);
        Map<String, String> documentHeadlinesMap = handler.getDirFileHeadlines();

        System.out.println("A. W1 Weight Scheme");
        Map<Short, Map<Short, Double>> w1QueryDocumentCosineStats = retrieval.getCosineSimilarity(queryIndexer.getDocuments(), corpusIndexer.getDocuments(), retrieval.W1_WEIGHING_SCHEME);
        prettyPrintQDDetails(w1QueryDocumentCosineStats, queryDocuments, corpusDocuments, documentHeadlinesMap);

        System.out.println("B. W2 Weight Scheme");
        retrieval.avgCorpusDocLen = retrieval.computeAvgDocLen(corpusDocuments);
        retrieval.avgQueryDocLen = retrieval.computeAvgDocLen(queryDocuments);
        Map<Short, Map<Short, Double>> w2QueryDocumentCosineStats = retrieval.getCosineSimilarity(queryIndexer.getDocuments(), corpusIndexer.getDocuments(), retrieval.W2_WEIGHING_SCHEME);
        prettyPrintQDDetails(w2QueryDocumentCosineStats, queryDocuments, corpusDocuments, documentHeadlinesMap);
    }
}
