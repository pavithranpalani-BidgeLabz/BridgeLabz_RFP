package org.example;

public class Contacts {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;

    public Contacts(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void showContact() {
        System.out.println("First Name  : " + firstName);
        System.out.println("Last  Name  : " + lastName);
        System.out.println("Address     : " + address);
        System.out.println("City        : " + city);
        System.out.println("State       : " + state);
        System.out.println("Zip         : " + zip);
        System.out.println("Phone No    : " + phoneNumber);
        System.out.println("Email       : " + email);
    }
}
