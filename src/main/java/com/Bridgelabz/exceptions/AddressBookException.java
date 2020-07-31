package com.Bridgelabz.exceptions;

public class AddressBookException extends Exception {

    public enum ExceptionType {ALREADY_PRESENT}

    private final ExceptionType type;

    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }


}
