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
        try {
            double result = (quantity.getFirstSubUnit().getBaseUnit().equals(quantity.getSecondSubUnit().getBaseUnit()))
                    ? quantity.getQuantity() * quantity.getFirstSubUnit().getUnit()
                    / quantity.getSecondSubUnit().getUnit() : null;
            return result;
        }catch (NullPointerException e) {
            throw new QuantityMeasurementException("Base Units Not Matches");
        }
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
