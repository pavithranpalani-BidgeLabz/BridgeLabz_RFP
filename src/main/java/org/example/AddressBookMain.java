import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    // Contact class (inside same file)
    static class Contact {
        String firstName, lastName, address, city, state, zip, phone, email;

        Contact(String firstName, String lastName, String address,
                String city, String state, String zip,
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
            System.out.println(firstName + " " + lastName + " | " +
                    address + ", " + city + ", " + state + " - " + zip +
                    " | Phone: " + phone + " | Email: " + email);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        System.out.println("Welcome to Address Book Program");

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            // ADD CONTACT
            if (choice == 1) {
                System.out.print("First Name: ");
                String firstName = sc.nextLine();

                System.out.print("Last Name: ");
                String lastName = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                System.out.print("City: ");
                String city = sc.nextLine();

                System.out.print("State: ");
                String state = sc.nextLine();

                System.out.print("Zip: ");
                String zip = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                contacts.add(new Contact(firstName, lastName, address,
                        city, state, zip, phone, email));

                System.out.println("Contact Added!");

            }

            // EDIT CONTACT
            else if (choice == 2) {
                System.out.print("Enter First Name to Edit: ");
                String name = sc.nextLine();

                for (Contact c : contacts) {
                    if (c.firstName.equalsIgnoreCase(name)) {

                        System.out.print("New City: ");
                        c.city = sc.nextLine();

                        System.out.print("New Phone: ");
                        c.phone = sc.nextLine();

                        System.out.println("Contact Updated!");
                        break;
                    }
                }
            }

            // DELETE CONTACT
            else if (choice == 3) {
                System.out.print("Enter First Name to Delete: ");
                String name = sc.nextLine();

                contacts.removeIf(c -> c.firstName.equalsIgnoreCase(name));

                System.out.println("Contact Deleted!");
            }

            // DISPLAY CONTACTS
            else if (choice == 4) {
                if (contacts.isEmpty()) {
                    System.out.println("No Contacts Found!");
                } else {
                    for (Contact c : contacts) {
                        c.display();
                    }
                }
            }

            // EXIT
            else if (choice == 5) {
                System.out.println("Thank You!");
                break;
            }

            else {
                System.out.println("Invalid Choice!");
            }
        }

        sc.close();
    }
}