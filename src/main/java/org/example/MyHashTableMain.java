package org.example;

public class MyHashTableMain {
    public static void main(String[] args) {
        String str = "To be or not to be";
        MyHashTable<String, Integer> map1 = new MyHashTable<>();
        String[] words = str.toLowerCase().split("");

        for (String word : words) {
            Integer value = map1.get(word);
            if (value == null) {
                map1.put(word, 1);
            } else {
                map1.put(word, value + 1);
            }
        }

        System.out.println("=== UC1 : Word Frequency (To Be Or Not To Be) ===");
        map1.display();

        System.out.println("=== UC2 : Word Frequency (Paragraph) ===");
        String paragraph = "Paranoids are not paranoid because they are paranoidbut because they keep putting themselves deliberately into paranoid avoidable situations";

        String[] words2 = paragraph.toLowerCase().split(" ");
        MyHashTable<String, Integer> map2 = new MyHashTable<>();
        for (String word : words2) {
            Integer value = map2.get(word);
            if (value == null)
                map2.put(word, 1);
            else
                map2.put(word, value + 1);
        }
        map2.display();

        System.out.println("=== UC3 : Remove 'avoidable' ===");
        boolean removed = map2.remove("avoidable");
        if (removed) {
            System.out.println("Word 'avoidable' removed successfully");
        } else {
            System.out.println("Word 'avoidable' not found");
        }
        System.out.println("After Removing:");
        map2.display();
    }
}