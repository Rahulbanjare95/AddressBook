package com.Bridgelabz.main.exceptions;

public class AddressBookException extends Exception {


    public enum ExceptionType {ALREADY_PRESENT}

    public  ExceptionType type;

    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }


}
