package main.java.utils;

import main.java.model.Document;

import java.util.Map;

public class Utils {

    private static byte counter = 0;

    public static double computeDotProduct(Map<String, Double> vector1, Map<String, Double> vector2) {
        double dotProduct = 0.0;
        for(String key: vector1.keySet()) {
            if(vector2.containsKey(key)) {
                dotProduct = dotProduct + (vector1.get(key) * vector2.get(key));
            }
        }
        return dotProduct;
    }

    public static void prettyPrintDocumentVector(String prefix, Document document) {
        System.out.format("%s %s (Term:TF-IDF Weights) %n", prefix, document.getName());
        System.out.format("%s%n", "------------------------------------------------------");
        counter = 0;
        document.getVector().forEach((key, value) -> {
            if(counter < 2) {
                System.out.format("%22s%10.4f", key, value);
                counter++;
            }
            else {
                System.out.format("%22s%10.4f%n", key, value);
                counter = 0;
            }
        });
        System.out.println();
    }

    public static void printDocOverview(Document document, int rank, double score, String headline) {
        System.out.format("%d.%15.6f%17s            %s%n", rank, score, document.getName(), headline);
    }
}
