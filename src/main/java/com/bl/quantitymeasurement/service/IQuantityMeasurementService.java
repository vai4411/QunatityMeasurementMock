package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;

import java.util.List;

public interface IQuantityMeasurementService {
    String unitConversion(Quantity quantity) throws QuantityMeasurementException;
    List<UnitConversion> getSubUnits(BaseUnit baseUnit);
    List<BaseUnit> getBaseUnits();
}
