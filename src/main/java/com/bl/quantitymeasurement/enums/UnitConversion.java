package com.bl.quantitymeasurement.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UnitConversion {

    Feet(12, BaseUnit.Length),
    Inch(1, BaseUnit.Length),
    Yard(36,BaseUnit.Length),
    Centimeter(0.4,BaseUnit.Length),

    Kilogram(1,BaseUnit.Weight),
    Gram(0.001,BaseUnit.Weight),
    Tonne(1000,BaseUnit.Weight),

    Litre(1,BaseUnit.Volume),
    Gallon(3.78,BaseUnit.Volume),
    Millilitre(0.001,BaseUnit.Volume),

    Celsius(1.8,BaseUnit.Temperature),
    Fahrenheit(0.55555555,BaseUnit.Temperature);

    private final double unit;
    private final BaseUnit baseUnit;

    UnitConversion(double unit, BaseUnit baseUnit) {
        this.unit = unit;
        this.baseUnit = baseUnit;
    }

    /**+
     * @purpose : This Method Use For Handling Proper BaseUnit Name Handling.
     * @param key
     * @return : Type Of SubUnit.
     */
    @JsonCreator
    public static UnitConversion fromString(String key) {
        for(UnitConversion type : UnitConversion.values()) {
            if(type.name().equalsIgnoreCase(key)) {
                return type;
            }
        }
        return null;
    }

    public double getUnit() {
        return unit;
    }

    public BaseUnit getBaseUnit() {
        return baseUnit;
    }
}
