package org.example;


@FunctionalInterface
interface UserValidation {
    boolean validate(String input);
}

public class UserRegistrationLambda {
    UserValidation firstNameValidator = name ->
            name.matches("^[A-Z][a-zA-Z]{2,}$");

    UserValidation lastNameValidator = name ->
            name.matches("^[A-Z][a-zA-Z]{2,}$");

    UserValidation emailValidator = email ->
            email.matches("^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$");

    UserValidation mobileValidator = mobile ->
            mobile.matches("^91\\s[0-9]{10}$");

    UserValidation passwordValidator = password ->
            password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}$");

    public static void main(String[] args) {
        UserRegistrationLambda lambda = new UserRegistrationLambda();
        System.out.println("First Name : " +
                lambda.firstNameValidator.validate("Abc"));

        System.out.println("Last Name  : " +
                lambda.lastNameValidator.validate("Kumar"));

        System.out.println("Email      : " +
                lambda.emailValidator.validate("abc.xyz@gmail.com"));

        System.out.println("Mobile     : " +
                lambda.mobileValidator.validate("91 9876543210"));

        System.out.println("Password   : " +
                lambda.passwordValidator.validate("Hello@123"));
    }
}
