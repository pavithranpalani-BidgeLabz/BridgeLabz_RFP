package org.example;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    List<Contacts> contactList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addContact(Contacts contacts) {
        if (contactList.isEmpty()) {
            contactList.add(contacts);
            System.out.println("Contact Added Successfully!");
        } else {
            boolean isDuplicate = contactList.stream()
                    .anyMatch(contacts1 -> contacts1.firstName.equalsIgnoreCase(contacts.firstName));
            if (isDuplicate) {
                System.out.println("Duplicate Entry! Person already exists.");
            } else {
                contactList.add(contacts);
                System.out.println("Contact Added Successfully!");
            }
        }
    }

    public void showALlContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        for (Contacts c : contactList) {
            c.showContact();
        }
    }

    public void editContact() {
        System.out.print("Enter First name of contact to edit: ");
        String name = sc.nextLine();

        for (Contacts contact : contactList) {
            if (contact.firstName.equalsIgnoreCase(name)) {
                System.out.println("Contact Found! Enter new details:");

                System.out.print("Enter Last Name : ");
                contact.lastName = sc.nextLine();

                System.out.print("Enter Address : ");
                contact.address = sc.nextLine();

                System.out.print("Enter City : ");
                contact.city = sc.nextLine();

                System.out.print("Enter State : ");
                contact.state = sc.nextLine();

                System.out.print("Enter Zip : ");
                contact.zip = sc.nextLine();

                System.out.print("Enter Phone Number : ");
                contact.phoneNumber = sc.nextLine();

                System.out.print("Enter Email : ");
                contact.email = sc.nextLine();

                System.out.print("Contact Updated Successfully!");
                return;
            }
        }
        System.out.println("Contact Not Found!");
    }

    public void deleteContact() {
        System.out.print("Enter First name of contact to delete: ");
        String name = sc.nextLine();

        for (Contacts contact : contactList) {
            if (contact.firstName.equalsIgnoreCase(name)) {
                contactList.remove(contact);
                System.out.println("Contact deleted Successfully");
                return;
            }
        }
        System.out.println("Contact Not Found!");
    }

    public void searchPersonByCity(String city, Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("People in city : " + city);
        if (city.isEmpty()) {
            System.out.println("City must have a value");
            return;
        }
        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(contacts -> contacts.city.equalsIgnoreCase(city))
                .forEach(contacts -> System.out.println(contacts.firstName + " " + contacts.lastName));
    }

    public void searchPersonByState(String state, Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("People in city : " + state);
        if (state.isEmpty()) {
            System.out.println("City must have a value");
            return;
        }
        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(contacts -> contacts.state.equalsIgnoreCase(state))
                .forEach(contacts -> System.out.println(contacts.firstName + " " + contacts.lastName));
    }

    public void viewPersonByCity(String city, Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("People in City : " + city);

        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(c -> c.city.equalsIgnoreCase(city))
                .forEach(c -> System.out.println(c.firstName + " " + c.lastName));
    }

    public void viewPersonByState(String state, Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("People in State : " + state);

        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(c -> c.state.equalsIgnoreCase(state))
                .forEach(c -> System.out.println(c.firstName + " " + c.lastName));
    }

    public void countPersonByCity(Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("---- Count By City ----");
        List<Contacts> allContacts = addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .collect(Collectors.toList());

        Map<String, Long> cityCount = allContacts.stream()
                .collect(Collectors.groupingBy(c -> c.city, Collectors.counting()));

        cityCount.forEach((city, count) -> System.out.println(city + " " + count));

    }

    public void countPersonByState(Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("---- Count By State ----");
        List<Contacts> allContacts = addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .collect(Collectors.toList());

        Map<String, Long> stateCount = allContacts.stream()
                .collect(Collectors.groupingBy(c -> c.city, Collectors.counting()));

        stateCount.forEach((state, count) -> System.out.println(state + " " + count));

    }

    public void sortedByPersonName() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }
        System.out.println("Contacts Sorted Alphabetically by Name:");
        contactList.stream()
                .sorted((c1, c2) -> c1.firstName.compareToIgnoreCase(c2.firstName))
                .forEach(System.out::println);
    }
    public void sortedByCity() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) -> c1.city.compareToIgnoreCase(c2.city))
                .forEach(System.out::println);
    }
    public void sortedByState() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) -> c1.state.compareToIgnoreCase(c2.state))
                .forEach(System.out::println);
    }
    public void sortedByZip() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) -> c1.zip.compareTo(c2.zip))
                .forEach(System.out::println);
    }

}
