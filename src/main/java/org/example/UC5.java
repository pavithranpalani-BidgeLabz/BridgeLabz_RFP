package org.example;

import java.util.ArrayList;

class ContactUc5 {

    String name;

    ContactUc5(String name) {
        this.name = name;
    }
}

public class UC5 {

    public static void main(String[] args) {

        ArrayList<ContactUc5> list = new ArrayList<>();

        list.add(new ContactUc5("Ranjith"));
        list.add(new ContactUc5("Kumar"));
        list.add(new ContactUc5("Arun"));

        for (ContactUc5 c : list) {
            System.out.println(c.name);
        }
    }
}
