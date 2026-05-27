package org.example;
import java.util.ArrayList;
import java.util.Comparator;

class ContactUc12 {

    String name;
    String city;

    ContactUc12(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class UC12 {

    public static void main(String[] args) {

        ArrayList<ContactUc12> list = new ArrayList<>();

        list.add(new ContactUc12("Ranjith", "Chennai"));
        list.add(new ContactUc12("Arun", "Madurai"));

        list.sort(Comparator.comparing(c -> c.city));

        for (ContactUc12 c : list) {
            System.out.println(c.name + " " + c.city);
        }
    }
}
