package main.java.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Document {

    private short id;

    private String name;

    private Map<String, Short> termMap;

    private short maxTF;

    private short length;

    private Map<String, Double> vector;

    public Document(short id) {
        this.id = id;
        termMap = new HashMap<>(1);
    }

    public void addTerm(String term) {
        if(termMap.containsKey(term)) {
            short frequency = termMap.get(term);
            if(maxTF < frequency + 1) {
                maxTF = (short)(frequency + 1);
            }
            termMap.put(term, (short)(frequency + 1));
        }
        else {
            termMap.put(term, (short) 1);
            if(maxTF < 1) {
                maxTF = (short) 1;
            }
        }
        length++;
    }

    public short getMaxTF() {
        return maxTF;
    }

    public short getLength() {
        return length;
    }

    public Map<String, Short> getTermMap() {
        return termMap;
    }

    public short getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getVector() {
        return vector;
    }

    public void generateW1Vector(short collectionSize, Map<String, LinkedList<PostingFileItem>> index) {
        vector = new HashMap<>();
        double value2 = Math.log10(collectionSize);
        double value3 = Math.log10(maxTF + 1.0);
        double normalizationValue = 0;
        for(String term: termMap.keySet()) {
            double df = index.get(term).size();
            double value1 = Math.log10(collectionSize * 1.0 / df * 1.0);
            double tf = termMap.get(term);
            double tfwt = (0.4 + (0.6 * Math.log10(tf + 0.5) / value3)) * (value1 / value2);
            double tfidf = tfwt * value1;
            normalizationValue = normalizationValue + (tfidf * tfidf);
            vector.put(term, tfidf);
        }
        normalizationValue = Math.sqrt(normalizationValue);
        for(String term: termMap.keySet()) {
            vector.put(term, vector.get(term) / normalizationValue);
        }
    }

    public void generateW2Vector(double avgdoclen, short collectionSize, Map<String, LinkedList<PostingFileItem>> index) {
        vector = new HashMap<>();
        double value2 = Math.log10(collectionSize);
        double value3 = 1.5 * (length / avgdoclen);
        double normalizationValue = 0.0;
        for(String term: termMap.keySet()) {
            double df = index.get(term).size();
            double value1 = Math.log10(collectionSize * 1.0 / df * 1.0);
            double tf = termMap.get(term);
            double tfwt = (0.4 + (0.6 * (tf / (tf + 0.5 + value3))) * value1 / value2);
            double tfidf = tfwt / value1;
            normalizationValue = normalizationValue + (tfidf * tfidf);
            vector.put(term, tfidf);
        }
        normalizationValue = Math.sqrt(normalizationValue);
        for(String term: termMap.keySet()) {
            vector.put(term, vector.get(term) / normalizationValue);
        }
    }
}
