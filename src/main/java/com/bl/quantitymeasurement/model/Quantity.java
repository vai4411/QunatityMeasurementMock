package com.bl.quantitymeasurement.model;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;

public class Quantity {
    private double quantity;
    private BaseUnit baseUnit;
    private UnitConversion firstSubUnit;
    private UnitConversion secondSubUnit;

    public Quantity() {
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setBaseUnit(BaseUnit baseUnit) {
        this.baseUnit = baseUnit;
    }

    public void setFirstSubUnit(UnitConversion firstSubUnit) {
        this.firstSubUnit = firstSubUnit;
    }

    public void setSecondSubUnit(UnitConversion secondSubUnit) {
        this.secondSubUnit = secondSubUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public BaseUnit getBaseUnit() {
        return baseUnit;
    }

    public UnitConversion getFirstSubUnit() {
        return firstSubUnit;
    }

    public UnitConversion getSecondSubUnit() {
        return secondSubUnit;
    }
}