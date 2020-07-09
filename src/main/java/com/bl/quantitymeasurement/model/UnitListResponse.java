package com.bl.quantitymeasurement.model;

import java.util.List;

public class UnitListResponse {

    private int status;
    private String message;
    private List units;

    public UnitListResponse(int status, String message, List units) {
        this.status = status;
        this.message = message;
        this.units = units;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getUnits() {
        return units;
    }

    public void setUnits(List units) {
        this.units = units;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
