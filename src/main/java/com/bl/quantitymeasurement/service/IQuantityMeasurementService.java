package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.model.Quantity;

import java.util.List;

public interface IQuantityMeasurementService {
    double unitConversion(Quantity quantity);
    List<UnitConversion> getSubUnits(BaseUnit baseUnit);
    List<BaseUnit> getBaseUnits();
}
