package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Contacts {

    String firstName;
    String lastName;

    Contacts(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void display() {
        System.out.println(firstName + " " + lastName);
    }
}

public class UC2 {

    public static void main(String[] args) {

        ArrayList<Contacts> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String first = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String last = sc.nextLine();

        Contacts c = new Contacts(first, last);

        list.add(c);

        System.out.println("\nContact Added");

        for (Contacts con : list) {
            con.display();
        }
    }
}
