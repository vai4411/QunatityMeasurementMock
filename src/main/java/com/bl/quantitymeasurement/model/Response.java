package com.bl.quantitymeasurement.model;

import java.io.Serializable;

public class Response implements Serializable {

    private String message;
    private long result;

    public Response(String message, long result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }
}
