package com.bl.quantitymeasurement.enums;

public enum UnitConversion {
    Feet(12, BaseUnit.Length),
    Inch(1, BaseUnit.Length),
    Yard(36,BaseUnit.Length);

    private final long unit;
    private final BaseUnit baseUnit;

    UnitConversion(long unit, BaseUnit baseUnit) {
        this.unit = unit;
        this.baseUnit = baseUnit;
    }

    public long getUnit() {
        return unit;
    }

    public BaseUnit getBaseUnit() {
        return baseUnit;
    }
}
