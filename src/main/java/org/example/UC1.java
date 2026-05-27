package org.example;

class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String email;

    Contact(String firstName, String lastName,
            String address, String city,
            String state, String zip,
            String phone, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println(firstName + " " + lastName);
        System.out.println(address);
        System.out.println(city + " " + state);
        System.out.println(zip);
        System.out.println(phone);
        System.out.println(email);
    }
}

public class UC1 {

    public static void main(String[] args) {

        Contact c = new Contact(
                "Ranjith",
                "Kumar",
                "Anna Nagar",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "9876543210",
                "ranjith@gmail.com");

        c.display();
    }
}
