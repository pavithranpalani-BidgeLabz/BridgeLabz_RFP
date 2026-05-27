package org.example;


public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        NO_SUCH_FILE,
        INVALID_FILE_TYPE,
        INCORRECT_DELIMITER,
        INCORRECT_HEADER
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {

        super(message);

        this.type = type;
    }
}
