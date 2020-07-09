package com.bl.quantitymeasurement.enums;

public enum  ResponseExceptionData {
    TypeMisMatchException("BaseUnit Not Matches"),
    Exception("Please Enter Proper Units And Quantity");

    private String data;

    ResponseExceptionData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
