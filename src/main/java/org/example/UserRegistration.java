package org.example;

import java.util.regex.Pattern;

public class UserRegistration {

    // UC1
    public static boolean uc1(String name) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        boolean isValidName = Pattern.matches(regex, name);
        return isValidName;
    }

    // UC2
    public static boolean uc2(String lastName) {
        String regex = "^(?:\\S+\\s)+[A-z][a-zA-Z]{2,}$";
        boolean isValidLastname = Pattern.matches(regex, lastName);
        return isValidLastname;
    }

    // UC3
    public static boolean uc3(String email) {
        String regex = "^[a-z][a-zA-Z0-9]*(\\.[a-zA-Z0-9]+)?@bl\\.co(\\.in)?$";
        boolean isValidEmail = Pattern.matches(regex, email);
        return isValidEmail;
    }

    // UC4
    public static boolean uc4(String number) {
        String regex = "^91\\s[0-9]{10}$";
        boolean isValidPhoneNumber = Pattern.matches(regex, number);
        return isValidPhoneNumber;
    }

    // UC5
    public static boolean uc5(String password) {
        String regex = "^.{8,}$";
        String input = "hello1234";
        boolean isValidPassword = Pattern.matches(regex, password);
        return isValidPassword;
    }

    // UC6
    public static boolean uc6(String password) {
        String regex = "^(?=.*[A-Z]).{8,}$";
        boolean isValidPassword = Pattern.matches(regex, password);
        return isValidPassword;
    }

    // UC7
    public static boolean uc7(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        boolean isValidPassword = Pattern.matches(regex, password);
        return isValidPassword;
    }

    // UC8
    public static boolean uc8(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$).{8,}$";
        boolean isValidPassword = Pattern.matches(regex, password);
        return isValidPassword;
    }

    // UC9
    public static boolean uc9(String password) {
        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})(\\.[a-zA-Z]{2,})?$";
        boolean isValidPassword = Pattern.matches(regex, password);
        return isValidPassword;
    }

    public static void main(String[] args) {
        boolean resultOfUc1 = uc1("hello");
        System.out.println("Valid name? " + resultOfUc1);

        boolean resultOfUC2 = uc2("Hello Hello");
        System.out.println("Valid last name? " + resultOfUC2);

        boolean resultOfUc3 = uc3("mail@bl.co");
        System.out.println("Valid mail? " + resultOfUc3);

        boolean resultOfUc4 = uc4("91 1234567890");
        System.out.println("Valid phone number? " + resultOfUc4);

        boolean resultOfUc5 = uc5("hello1234");
        System.out.println("Valid password? " + resultOfUc5);

        boolean resultOfUc6 = uc6("Hello1234");
        System.out.println("Valid password? " + resultOfUc6);

        boolean resultOfUc7 = uc7("Hello@1234");
        System.out.println("Valid password? " + resultOfUc7);

        boolean resultOfUc8 = uc8("Hello@1234");
        System.out.println("Valid password? " + resultOfUc8);

        boolean resultOfUc9 = uc9("abc@mail.com");
        System.out.println("Valid email? " + resultOfUc9);

    }
}
