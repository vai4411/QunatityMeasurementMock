package com.bl.quantitymeasurement.enums;

public enum ResponseMessage {
    ConversionSuccess(200,"Unit Converted Successfully"),
    SubUnitSuccess(200,"SubUnit List Getting Successfully"),
    BaseUnitSuccess(200,"BaseUnit List Getting Successfully"),
    TypeMisMatchException(400,"Type Mismatch Exception Occurs"),
    NullPointerException(400,"Null Pointer Exception Occurs"),
    Exception(400,"Nested Exception Occurs");

    private int status;
    private String message;

    ResponseMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
