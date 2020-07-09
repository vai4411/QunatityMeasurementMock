package com.bl.quantitymeasurement.model;

import java.io.Serializable;

public class ConversionResponse implements Serializable {

    private int status;
    private String message;
    private String result;

    public ConversionResponse(int status, String message, String result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
