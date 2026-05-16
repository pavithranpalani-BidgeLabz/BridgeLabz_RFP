package org.example;

public class UserValidationException extends Exception {
    public enum Type {
        INVALID_FIRST_NAME,
        INVALID_LAST_NAME,
        INVALID_EMAIL,
        INVALID_PHONE,
        INVALID_PASSWORD
    }

    public Type type;

    public UserValidationException(Type type, String message) {
        super(message);
        this.type = type;
    }
}
