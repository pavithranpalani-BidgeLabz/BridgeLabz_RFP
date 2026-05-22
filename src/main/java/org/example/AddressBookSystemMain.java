package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystemMain {
    public static final Map<String, AddressBookSystem> addressBookSystemMap = new HashMap<>();
    public static final AddressBookSystem book = new AddressBookSystem();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----Address Book System ----");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Open Existing Address Book");
            System.out.println("3. Show All Address Books");
            System.out.println("4. Exit");
            System.out.print("Enter Option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book name: ");
                    String name = sc.nextLine();
                    if (addressBookSystemMap.containsKey(name)) {
                        System.out.println("Address Book Already Exists!");
                    } else {
                        addressBookSystemMap.put(name, new AddressBookSystem());
                        System.out.println("Address Book Created Successfully!");
                    }
                    break;
                case 2:
                    System.out.print("Enter Address Book name: ");
                    String bookName = sc.nextLine();

                    AddressBookSystem bookSystem = addressBookSystemMap.get(bookName);
                    if (bookSystem == null) {
                        System.out.println("Address Book Not Found!");
                    } else {
                        addContactsInAddressBook(bookSystem);
                    }
                    break;
                case 3:
                    System.out.println("Available Address Book");
                    for (String key : addressBookSystemMap.keySet()) {
                        System.out.println(key);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }


    }

    public static void addContactsInAddressBook(AddressBookSystem book) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Show Contacts");
            System.out.println("4. Delete Contacts");
            System.out.println("5. Search for people by city");
            System.out.println("6. Search for people by state");
            System.out.println("7. view for people by city");
            System.out.println("8. view for people by state");
            System.out.println("9. contact person count by city");
            System.out.println("10. contact person count by state");
            System.out.println("11. Exit");

            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name : ");
                    String firstName = sc.nextLine();

                    System.out.print("Enter Last Name : ");
                    String lastName = sc.nextLine();

                    System.out.print("Enter Address : ");
                    String address = sc.nextLine();

                    System.out.print("Enter City : ");
                    String city = sc.nextLine();

                    System.out.print("Enter State : ");
                    String state = sc.nextLine();

                    System.out.print("Enter Zip : ");
                    String zip = sc.nextLine();

                    System.out.print("Enter Phone Number : ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email : ");
                    String email = sc.nextLine();

                    Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phone, email);
                    book.addContact(contact);

                    break;
                case 2:
                    book.editContact();
                    break;

                case 3:
                    book.showALlContacts();
                    break;
                case 4:
                    book.deleteContact();
                    break;
                case 5:
                    String searchPersonByCity = sc.nextLine();
                    book.searchPersonByCity(searchPersonByCity, addressBookSystemMap);
                case 6:
                    String searchPersonByState = sc.nextLine();
                    book.searchPersonByState(searchPersonByState, addressBookSystemMap);
                case 7:
                    String viewPersonByCity = sc.nextLine();
                    book.viewPersonByCity(viewPersonByCity, addressBookSystemMap);
                case 8:
                    String viewPersonByState = sc.nextLine();
                    book.viewPersonByState(viewPersonByState, addressBookSystemMap);
                case 9:
                    book.countPersonByCity(addressBookSystemMap);
                case 10:
                    book.countPersonByState(addressBookSystemMap);
                case 11:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
