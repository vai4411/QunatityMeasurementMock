package com.bl.quantitymeasurement.enums;

public enum UnitConversion {
    Feet(12, BaseUnit.Length),
    Inch(1, BaseUnit.Length),
    Yard(36,BaseUnit.Length),
    CM(0.4,BaseUnit.Length);

    private final double unit;
    private final BaseUnit baseUnit;

    UnitConversion(double unit, BaseUnit baseUnit) {
        this.unit = unit;
        this.baseUnit = baseUnit;
    }

    public double getUnit() {
        return unit;
    }

    public BaseUnit getBaseUnit() {
        return baseUnit;
    }
}
