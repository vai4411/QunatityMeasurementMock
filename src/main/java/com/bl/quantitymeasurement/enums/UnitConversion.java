package com.bl.quantitymeasurement.enums;

public enum UnitConversion {
    Feet(12),
    Inch(1);

    UnitConversion(long unit) {
        this.unit = unit;
    }

    private final long unit;

    public long getUnit() {
        return unit;
    }
}
