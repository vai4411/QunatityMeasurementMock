package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.model.Quantity;

import java.util.List;

public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public long unitConversion(Quantity quantity) {
        return 0;
    }

    @Override
    public List<UnitConversion> getSubUnits(BaseUnit baseUnit) {
        return null;
    }
}
