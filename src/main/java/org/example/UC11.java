package org.example;
import java.util.ArrayList;
import java.util.Collections;

public class UC11 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Ranjith");
        list.add("Arun");
        list.add("Kumar");

        Collections.sort(list);

        for (String name : list) {
            System.out.println(name);
        }
    }
}
