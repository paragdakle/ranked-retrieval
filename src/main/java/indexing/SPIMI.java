package main.java.indexing;

import main.java.model.Document;
import main.java.model.PostingFileItem;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SPIMI {

    private Map<String, LinkedList<PostingFileItem>> index = null;
    private String[] docIds;
    private int[] maxDocTermFrequency;
    private int maxTermLength = -1;
    private Document[] documents;

    public void createIndex(Map<String, List<String>> termMap, String outFile) {
        docIds = new String[termMap.size() + 1];
        int counter = 1;
        docIds[0] = "";
        documents = new Document[termMap.size()];

        for(String docId: termMap.keySet()) {
            try {
                Document document = new Document((short) (counter - 1));
                document.setName(docId);
                if(!docIds[counter - 1].equals(docId)) {
                    docIds[counter] = docId;
                }
                List<String> termList = termMap.get(docId);
                if(index == null) {
                    index = new LinkedHashMap<>();
                }
                for(String term: termList) {
                    if(maxTermLength < term.length()) {
                        maxTermLength = term.length();
                    }
                    document.addTerm(term);
                    if(index.containsKey(term)) {
                        LinkedList<PostingFileItem> postingList = index.get(term);
                        PostingFileItem postingFileItem = new PostingFileItem(counter);
                        int itemIndex = postingList.indexOf(postingFileItem);
                        if(itemIndex > -1) {
                            postingList.get(itemIndex).incrementTermFrequency();
                        }
                        else {
                            postingList.add(postingFileItem);
                        }
                    }
                    else {
                        PostingFileItem postingFileItem = new PostingFileItem(counter);
                        LinkedList<PostingFileItem> postingList = new LinkedList<>();
                        postingList.add(postingFileItem);
                        index.put(term, postingList);
                    }
                }
                documents[counter - 1] = document;
                counter++;
            }
            catch (OutOfMemoryError e) {
                System.out.println(e.getMessage());
            }
        }
        sortIndex();
        if(!outFile.isEmpty()) {
            writeIndexToFile(outFile + ".txt");
        }
    }

    private void sortIndex() {
        index = index.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
    }

    private void writeIndexToFile(String outFile) {
        try {
            File file = new File(outFile);
            if (file.exists()) {
                file.createNewFile();
            }
            if(file.isDirectory()) {
                System.out.println("Invalid file path provided. Kindly provide a valid file path!");
            }
            maxDocTermFrequency = new int[docIds.length];
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for(String term: index.keySet()) {
                writer.write(getIndexFileItem(term, index.get(term)));
                writer.flush();
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getIndexFileItem(String term, LinkedList<PostingFileItem> postingList) {
        StringBuilder builder = new StringBuilder();
        builder.append(term);
        for(int counter = 0; counter < (maxTermLength - term.length()); counter++) {
            builder.append(' ');
        }
        builder.append(postingList.size());
        for(PostingFileItem postingFileItem: postingList) {
            builder.append(postingFileItem.getDocId())
                    .append(postingFileItem.getTermFrequency());
            if(maxDocTermFrequency[postingFileItem.getDocId()] < postingFileItem.getTermFrequency()) {
                maxDocTermFrequency[postingFileItem.getDocId()] = postingFileItem.getTermFrequency();
            }
        }
        return builder.append("\n").toString();
    }

    public Map<String, LinkedList<PostingFileItem>> getIndex() {
        return index;
    }

    public Document[] getDocuments() {
        return documents;
    }

    public String[] getDocIds() {
        return docIds;
    }
}
