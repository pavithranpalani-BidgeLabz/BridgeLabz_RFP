package org.example;

import java.util.ArrayList;

class Contactuc10 {

    String name;
    String city;

    Contactuc10(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class UC10 {

    public static void main(String[] args) {

        ArrayList<Contactuc10> list = new ArrayList<>();

        list.add(new Contactuc10("Ranjith", "Chennai"));
        list.add(new Contactuc10("Arun", "Chennai"));

        long count = list.stream()
                .filter(c -> c.city.equals("Chennai"))
                .count();

        System.out.println("Count : " + count);
    }
}
