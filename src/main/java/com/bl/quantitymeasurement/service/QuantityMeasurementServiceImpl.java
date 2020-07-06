package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.model.Quantity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Override
    public double unitConversion(Quantity quantity) {
        double result = (quantity.getBaseUnit().equals(quantity.getBaseUnit()))
                ? quantity.getQuantity() * quantity.getFirstSubUnit().getUnit()
                /quantity.getSecondSubUnit().getUnit() : null;
        return result;
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
