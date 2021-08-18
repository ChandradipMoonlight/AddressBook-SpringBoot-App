package com.addressbookapp.constant;

public enum ExceptionConstants {

    ID_NOT_FOUND("Id not found");

    private String message;

    ExceptionConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}