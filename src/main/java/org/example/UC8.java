package org.example;

import java.util.ArrayList;

class ContactUc8 {

    String name;
    String city;

    ContactUc8(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class UC8 {

    public static void main(String[] args) {

        ArrayList<ContactUc8> list = new ArrayList<>();

        list.add(new ContactUc8("Ranjith", "Chennai"));
        list.add(new ContactUc8("Arun", "Madurai"));

        list.stream()
                .filter(c -> c.city.equals("Chennai"))
                .forEach(c -> System.out.println(c.name));
    }
}
