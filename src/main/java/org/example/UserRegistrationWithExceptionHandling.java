package org.example;

import java.util.regex.Pattern;

public class UserRegistrationWithExceptionHandling {
    // UC1
    public boolean uc1(String name) throws UserValidationException {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        if (!Pattern.matches(regex, name))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_FIRST_NAME,
                    "Invalid First Name");
        return true;
    }

    // UC2
    public boolean uc2(String lastName) throws UserValidationException {
        String regex = "^(?:\\S+\\s)+[A-Za-z]{3,}$";
        if (!Pattern.matches(regex, lastName))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_LAST_NAME,
                    "Invalid Last Name");
        return true;
    }

    // UC3
    public boolean uc3(String email) throws UserValidationException {
        String regex = "^[a-z][a-zA-Z0-9]*(\\.[a-zA-Z0-9]+)?@bl\\.co(\\.in)?$";
        if (!Pattern.matches(regex, email))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_EMAIL,
                    "Invalid Email");
        return true;
    }

    // UC4
    public boolean uc4(String number) throws UserValidationException {
        String regex = "^91\\s[0-9]{10}$";
        if (!Pattern.matches(regex, number))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_PHONE,
                    "Invalid Phone");
        return true;
    }

    // UC5
    public boolean uc5(String password) throws UserValidationException {
        String regex = "^.{8,}$";
        if (!Pattern.matches(regex, password))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_PASSWORD,
                    "Password must be min 8 chars");
        return true;
    }

    // UC6
    public boolean uc6(String password) throws UserValidationException {
        String regex = "^(?=.*[A-Z]).{8,}$";
        if (!Pattern.matches(regex, password))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_PASSWORD,
                    "Password must have 1 capital letter");
        return true;
    }

    // UC7
    public boolean uc7(String password) throws UserValidationException {
        String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        if (!Pattern.matches(regex, password))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_PASSWORD,
                    "Password must have 1 number");
        return true;
    }

    // UC8
    public boolean uc8(String password) throws UserValidationException {
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$).{8,}$";
        if (!Pattern.matches(regex, password))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_PASSWORD,
                    "Password must contain 1 special char");
        return true;
    }

    // UC9
    public static boolean uc9(String email) throws UserValidationException {
        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})(\\.[a-zA-Z]{2,})?$";
        if (!Pattern.matches(regex, email))
            throw new UserValidationException(
                    UserValidationException.Type.INVALID_EMAIL,
                    "Invalid Sample Email");
        return true;
    }
}
