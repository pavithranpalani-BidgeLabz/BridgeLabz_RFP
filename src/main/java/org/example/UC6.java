package org.example;

import java.util.HashMap;

public class UC6 {

    public static void main(String[] args) {

        HashMap<String, String> addressBook = new HashMap<>();

        addressBook.put("Friends", "Ranjith");
        addressBook.put("Office", "Arun");

        for (String key : addressBook.keySet()) {
            System.out.println(key + " : " + addressBook.get(key));
        }
    }
}
