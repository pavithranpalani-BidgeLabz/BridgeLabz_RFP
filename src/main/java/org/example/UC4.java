package org.example;

import java.util.ArrayList;

class ContactUc4 {

    String name;

    ContactUc4(String name) {
        this.name = name;
    }
}

public class UC4 {

    public static void main(String[] args) {

        ArrayList<ContactUc4> list = new ArrayList<>();

        list.add(new ContactUc4("Ranjith"));
        list.add(new ContactUc4("Arun"));

        list.removeIf(c -> c.name.equals("Arun"));

        for (ContactUc4 c : list) {
            System.out.println(c.name);
        }
    }
}
