package com.bl.quantitymeasurement.enums;

public enum  SubUnits {

    Feet("Feet"),
    Inch("Inch");

    private String baseUnit;

    SubUnits(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public String getBaseUnit() {
        return baseUnit;
    }
}
