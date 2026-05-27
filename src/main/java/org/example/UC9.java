package org.example;

import java.util.ArrayList;
import java.util.HashMap;

class ContactUc9 {

    String name;
    String city;

    ContactUc9(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class UC9 {

    public static void main(String[] args) {

        ArrayList<ContactUc9> list = new ArrayList<>();

        list.add(new ContactUc9("Ranjith", "Chennai"));
        list.add(new ContactUc9("Arun", "Madurai"));

        HashMap<String, ArrayList<String>> cityMap = new HashMap<>();

        for (ContactUc9 c : list) {

            cityMap.putIfAbsent(c.city, new ArrayList<>());
            cityMap.get(c.city).add(c.name);
        }

        System.out.println(cityMap);
    }
}
