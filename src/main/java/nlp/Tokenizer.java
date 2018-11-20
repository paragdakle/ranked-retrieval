package main.java.nlp;

import main.java.filter.IFilter;
import main.java.io.FileHandler;

import java.util.*;

public class Tokenizer {

    private final byte TOTAL_TOKENS_INDEX = 0;
    private final byte UNIQUE_WORDS_INDEX = 1;
    private final byte ONCE_WORDS_INDEX = 2;
    private final byte AVG_WORDS_DOC_INDEX = 3;

    public static final byte PLAIN_TOKENS = 0;
    public static final byte LEMMA_TOKENS = 1;
    public static final byte STEM_TOKENS = 2;

    private Map<String, List<String>> tokenMap;

    private IFilter filter;

    private byte mode;

    private Lemmatizer lemmatizer;

    private Stemmer stemmer;

    private HashSet<String> stopWords;

    public Tokenizer(IFilter filter) {
        this.tokenMap = new LinkedHashMap<>();
        this.filter = filter;
        stopWords = new HashSet<>(1);
    }

    public Tokenizer(byte mode, IFilter filter) {
        this.tokenMap = new LinkedHashMap<>();
        this.filter = filter;
        this.mode = mode;
        if(this.mode == LEMMA_TOKENS) {
            lemmatizer = new Lemmatizer();
        }
        else if(this.mode == STEM_TOKENS) {
            stemmer = new Stemmer();
        }
        stopWords = new HashSet<>(1);
    }

    public Tokenizer(byte mode, HashSet<String> stopWords, IFilter filter) {
        this.tokenMap = new LinkedHashMap<>();
        this.filter = filter;
        this.mode = mode;
        if(this.mode == LEMMA_TOKENS) {
            lemmatizer = new Lemmatizer();
        }
        else if(this.mode == STEM_TOKENS) {
            stemmer = new Stemmer();
        }
        this.stopWords = stopWords;
    }

    public Map<String, List<String>> getTokenMap() {
        return this.tokenMap;
    }

    public IFilter getFilter() {
        return this.filter;
    }

    public void tokenize(String dataPath, IFilter filter, boolean doFormatting) {
        if(filter == null) {
            return;
        }
        filter.construct();
        FileHandler handler = new FileHandler(dataPath, filter, doFormatting);
        this.tokenize(handler.read());
    }

    public void tokenize(Map<String, String> content) {
        content.forEach((filename, contents) -> {
            String[] contentSplit;
            if(mode == LEMMA_TOKENS) {
                contentSplit = lemmatizer.lemmatize(contents);
            }
            else if(mode == STEM_TOKENS) {
                contentSplit = stemmer.stem(contents);
            }
            else {
                contentSplit = contents.split(" ");
            }
            tokenMap.put(filename, new ArrayList<>());
            for (String item : contentSplit) {
                item = item.trim();
                if(!item.equals("") && !stopWords.contains(item)) {
                    tokenMap.get(filename).add(item);
                }
            }
        });
    }
}
