package org.example;

public class SearchSpecificWord {
    private static String findSearchSpecificWord(String[] strs, String word) {
        for (String str : strs) {
            if (str.contains(word)) {
                return str;
            }
        }
        return "Not found";
    }

    public static void main(String[] args) {
        String[] str = {
                "Java is powerful",
                "Data Structures are important",
                "Programming makes problem solving easier"
        };
        String word = "makes";
        String results = findSearchSpecificWord(str, word);
        System.out.println("Specific Word in sentence: " + results);
    }
}
