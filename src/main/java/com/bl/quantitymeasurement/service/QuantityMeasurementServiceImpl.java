package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Override
    public double unitConversion(Quantity quantity) throws QuantityMeasurementException {
        if (quantity.getFirstSubUnit().getBaseUnit().equals(quantity.getSecondSubUnit().getBaseUnit())) {
            if (quantity.getFirstSubUnit().equals(UnitConversion.Celsius) && quantity.getSecondSubUnit().equals(UnitConversion.Fahrenheit)) {
                return quantity.getFirstSubUnit().getUnit() * 9 / 5 + 32; }
            if (quantity.getFirstSubUnit().equals(UnitConversion.Fahrenheit) && quantity.getSecondSubUnit().equals(UnitConversion.Celsius)) {
                return quantity.getFirstSubUnit().getUnit() - 32 * 5 / 9; }
            return quantity.getQuantity() * quantity.getFirstSubUnit().getUnit() / quantity.getSecondSubUnit().getUnit();
        }
        else
            throw new QuantityMeasurementException("Base Units Not Matches");
    }

    @Override
    public List<UnitConversion> getSubUnits(BaseUnit baseUnit) {
        return null;
    }

    @Override
    public List<BaseUnit> getBaseUnits() {
        return null;
    }
}
