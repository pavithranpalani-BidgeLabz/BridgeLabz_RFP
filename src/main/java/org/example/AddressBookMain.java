import java.util.*;

public class AddressBookMain {

    // ─── Contact (UC1) ───────────────────────────────────────────────
    static class Contact {
        String firstName, lastName, address, city, state, zip, phone, email;

        Contact(String firstName, String lastName, String address, String city,
                String state, String zip, String phone, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address  = address;
            this.city     = city;
            this.state    = state;
            this.zip      = zip;
            this.phone    = phone;
            this.email    = email;
        }

        public String toString() {
            return "\n--- Contact ---" +
                    "\nName    : " + firstName + " " + lastName +
                    "\nAddress : " + address + ", " + city + ", " + state + " " + zip +
                    "\nPhone   : " + phone +
                    "\nEmail   : " + email;
        }
    }

    // ─── AddressBook (UC4 + UC5) ──────────────────────────────────────
    static class AddressBook {
        String name;
        List<Contact> contacts = new ArrayList<>();   // UC4: Collection for multiple contacts

        AddressBook(String name) {
            this.name = name;
        }

        // UC1 – Add
        void addContact(Scanner sc) {
            System.out.println("\n-- Add New Contact --");
            System.out.print("First Name : "); String fn    = sc.nextLine();
            System.out.print("Last Name  : "); String ln    = sc.nextLine();
            System.out.print("Address    : "); String addr  = sc.nextLine();
            System.out.print("City       : "); String city  = sc.nextLine();
            System.out.print("State      : "); String state = sc.nextLine();
            System.out.print("Zip        : "); String zip   = sc.nextLine();
            System.out.print("Phone      : "); String phone = sc.nextLine();
            System.out.print("Email      : "); String email = sc.nextLine();
            contacts.add(new Contact(fn, ln, addr, city, state, zip, phone, email));
            System.out.println("Contact added successfully!");
        }

        // UC2 – Edit
        void editContact(Scanner sc) {
            System.out.print("\nEnter First Name to edit: "); String fn = sc.nextLine();
            System.out.print("Enter Last Name to edit  : "); String ln = sc.nextLine();

            for (Contact c : contacts) {
                if (c.firstName.equalsIgnoreCase(fn) && c.lastName.equalsIgnoreCase(ln)) {
                    System.out.println("Found: " + c);
                    System.out.println("\nEnter new details (press Enter to keep existing):");

                    System.out.print("Address [" + c.address + "]: ");
                    String val = sc.nextLine(); if (!val.isEmpty()) c.address = val;

                    System.out.print("City    [" + c.city    + "]: ");
                    val = sc.nextLine(); if (!val.isEmpty()) c.city = val;

                    System.out.print("State   [" + c.state   + "]: ");
                    val = sc.nextLine(); if (!val.isEmpty()) c.state = val;

                    System.out.print("Zip     [" + c.zip     + "]: ");
                    val = sc.nextLine(); if (!val.isEmpty()) c.zip = val;

                    System.out.print("Phone   [" + c.phone   + "]: ");
                    val = sc.nextLine(); if (!val.isEmpty()) c.phone = val;

                    System.out.print("Email   [" + c.email   + "]: ");
                    val = sc.nextLine(); if (!val.isEmpty()) c.email = val;

                    System.out.println("Contact updated successfully!");
                    return;
                }
            }
            System.out.println("Contact not found.");
        }

        // UC3 – Delete
        void deleteContact(Scanner sc) {
            System.out.print("\nEnter First Name to delete: "); String fn = sc.nextLine();
            System.out.print("Enter Last Name to delete  : "); String ln = sc.nextLine();

            Iterator<Contact> it = contacts.iterator();
            while (it.hasNext()) {
                Contact c = it.next();
                if (c.firstName.equalsIgnoreCase(fn) && c.lastName.equalsIgnoreCase(ln)) {
                    it.remove();
                    System.out.println("Contact deleted successfully!");
                    return;
                }
            }
            System.out.println("Contact not found.");
        }

        // UC4 – Add multiple contacts one at a time
        void addMultipleContacts(Scanner sc) {
            while (true) {
                addContact(sc);
                System.out.print("\nAdd another contact? (yes/no): ");
                if (!sc.nextLine().trim().equalsIgnoreCase("yes")) break;
            }
        }

        // Display all contacts in this address book
        void displayContacts() {
            if (contacts.isEmpty()) {
                System.out.println("\nNo contacts in [" + name + "].");
                return;
            }
            System.out.println("\n=== Contacts in Address Book: " + name + " ===");
            for (Contact c : contacts) System.out.println(c);
        }
    }

    // ─── UC5: Dictionary of AddressBook Name → AddressBook ───────────
    static Map<String, AddressBook> addressBookDictionary = new LinkedHashMap<>();
    static Scanner scanner = new Scanner(System.in);

    // ─── Main ─────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Welcome to Address Book ===");

        while (true) {
            System.out.println("\n====== MAIN MENU ======");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Display All Address Books");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            String input = scanner.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(input); }
            catch (NumberFormatException e) { System.out.println("Invalid input."); continue; }

            switch (choice) {
                case 1: createAddressBook(); break;
                case 2: selectAddressBook(); break;
                case 3: displayAllAddressBooks(); break;
                case 4:
                    System.out.println("\nThank You! Goodbye.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // UC5 – Create a new named Address Book
    static void createAddressBook() {
        System.out.print("\nEnter Address Book name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        if (addressBookDictionary.containsKey(name)) {
            System.out.println("Address Book '" + name + "' already exists.");
            return;
        }
        addressBookDictionary.put(name, new AddressBook(name));
        System.out.println("Address Book '" + name + "' created successfully!");
    }

    // Select an Address Book and operate on it
    static void selectAddressBook() {
        if (addressBookDictionary.isEmpty()) {
            System.out.println("\nNo Address Books found. Please create one first.");
            return;
        }

        System.out.println("\nAvailable Address Books:");
        addressBookDictionary.keySet().forEach(k -> System.out.println("  - " + k));
        System.out.print("Enter Address Book name: ");
        String name = scanner.nextLine().trim();

        AddressBook ab = addressBookDictionary.get(name);
        if (ab == null) {
            System.out.println("Address Book '" + name + "' not found.");
            return;
        }

        addressBookMenu(ab);
    }

    // Sub-menu for a selected Address Book
    static void addressBookMenu(AddressBook ab) {
        while (true) {
            System.out.println("\n--- Address Book: " + ab.name + " ---");
            System.out.println("1. Add Contact          (UC1)");
            System.out.println("2. Edit Contact         (UC2)");
            System.out.println("3. Delete Contact       (UC3)");
            System.out.println("4. Add Multiple Contacts(UC4)");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose option: ");

            String input = scanner.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(input); }
            catch (NumberFormatException e) { System.out.println("Invalid input."); continue; }

            switch (choice) {
                case 1: ab.addContact(scanner);          break;
                case 2: ab.editContact(scanner);         break;
                case 3: ab.deleteContact(scanner);       break;
                case 4: ab.addMultipleContacts(scanner); break;
                case 5: ab.displayContacts();            break;
                case 6: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    // Display names of all Address Books (UC5)
    static void displayAllAddressBooks() {
        if (addressBookDictionary.isEmpty()) {
            System.out.println("\nNo Address Books available.");
            return;
        }
        System.out.println("\n=== All Address Books ===");
        for (Map.Entry<String, AddressBook> entry : addressBookDictionary.entrySet()) {
            System.out.println("\n>> " + entry.getKey() +
                    " (" + entry.getValue().contacts.size() + " contact(s))");
            entry.getValue().displayContacts();
        }
    }
}