package org.example;

import java.util.ArrayList;

class Contactss {

    String name;
    String phone;

    Contactss(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class UC3 {

    public static void main(String[] args) {

        ArrayList<Contactss> list = new ArrayList<>();

        list.add(new Contactss("Ranjith", "9876543210"));

        for (Contactss c : list) {

            if (c.name.equals("Ranjith")) {
                c.phone = "9999999999";
            }
        }

        for (Contactss c : list) {
            System.out.println(c.name + " " + c.phone);
        }
    }
}
