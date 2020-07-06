package com.bl.quantitymeasurement.model;

public class Quantity {
    private long quantity;
    private String baseUnit;
    private long firstSubUnit;
    private long secondSubUnit;

    public Quantity() {
    }

    public Quantity(long quantity, String baseUnit, long firstSubUnit, long secondSubUnit) {
        this.quantity = quantity;
        this.baseUnit = baseUnit;
        this.firstSubUnit = firstSubUnit;
        this.secondSubUnit = secondSubUnit;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public void setFirstSubUnit(long firstSubUnit) {
        this.firstSubUnit = firstSubUnit;
    }

    public void setSecondSubUnit(long secondSubUnit) {
        this.secondSubUnit = secondSubUnit;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public long getFirstSubUnit() {
        return firstSubUnit;
    }

    public long getSecondSubUnit() {
        return secondSubUnit;
    }
}
