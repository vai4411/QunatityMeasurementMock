package com.bl.quantitymeasurement.enums;

public enum  BaseUnit {
    Length("Length");

    private String unit;

    BaseUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
