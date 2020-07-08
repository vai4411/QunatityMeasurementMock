package com.bl.quantitymeasurement.model;

import java.io.Serializable;
import java.util.List;

public class ConversionResponse implements Serializable {

    private String message;
    private double result;

    public ConversionResponse(String message, double result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
