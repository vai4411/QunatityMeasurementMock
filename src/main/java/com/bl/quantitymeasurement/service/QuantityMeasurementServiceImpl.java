package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;
import com.bl.quantitymeasurement.util.ConstantMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Override
    public double unitConversion(Quantity quantity) throws QuantityMeasurementException {
        try {
            if (quantity.getFirstSubUnit().getBaseUnit().equals(quantity.getSecondSubUnit().getBaseUnit())) {
                if (quantity.getFirstSubUnit().equals(UnitConversion.Celsius) && quantity.getSecondSubUnit().equals(UnitConversion.Fahrenheit)) {
                    return (quantity.getQuantity() * quantity.getFirstSubUnit().getUnit()) + 32;
                }
                if (quantity.getFirstSubUnit().equals(UnitConversion.Fahrenheit) && quantity.getSecondSubUnit().equals(UnitConversion.Celsius)) {
                    return (quantity.getQuantity() - 32) * quantity.getFirstSubUnit().getUnit();
                }
                return quantity.getQuantity() * quantity.getFirstSubUnit().getUnit() / quantity.getSecondSubUnit().getUnit();
            } else
                throw new QuantityMeasurementException(ConstantMessage.getConversionFailException);
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(ConstantMessage.getNullValueException);
        }
    }

    @Override
    public List<UnitConversion> getSubUnits(BaseUnit baseUnit) {
            return Arrays.stream(UnitConversion.values())
                    .filter(qUnit -> qUnit.getBaseUnit().equals(baseUnit))
                    .collect(Collectors.toList());
    }

    @Override
    public List<BaseUnit> getBaseUnits() {
        return Arrays.asList(BaseUnit.values());
    }
}
