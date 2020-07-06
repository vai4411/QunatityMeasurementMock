package com.bl.quantitymeasurement.model;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;

public class Quantity {
    private long quantity;
    private BaseUnit baseUnit;
    private UnitConversion firstSubUnit;
    private UnitConversion secondSubUnit;

    public Quantity() {
    }

    public Quantity(long quantity, BaseUnit baseUnit, UnitConversion firstSubUnit, UnitConversion secondSubUnit) {
        this.quantity = quantity;
        this.baseUnit = baseUnit;
        this.firstSubUnit = firstSubUnit;
        this.secondSubUnit = secondSubUnit;
    }

    public void setQuantity(long quantity) {
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

    public long getQuantity() {
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
