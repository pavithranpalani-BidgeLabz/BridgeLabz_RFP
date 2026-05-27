package org.example;
import java.util.ArrayList;

class Contactuc7 {

    String name;

    Contactuc7(String name) {
        this.name = name;
    }
}

public class UC7 {

    public static void main(String[] args) {

        ArrayList<Contactuc7> list = new ArrayList<>();

        Contactuc7 c1 = new Contactuc7("Ranjith");
        Contactuc7 c2 = new Contactuc7("Ranjith");

        boolean exists = list.stream()
                .anyMatch(c -> c.name.equals(c2.name));

        if (!exists) {
            list.add(c1);
            System.out.println("Added");
        }

        exists = list.stream()
                .anyMatch(c -> c.name.equals(c2.name));

        if (!exists) {
            list.add(c2);
        } else {
            System.out.println("Duplicate Not Allowed");
        }
    }
}
