package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.ResponseExceptionData;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//import com.bl.quantitymeasurement.util.ConstantMessage;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    /**+
     * @purpose : This Method Used For The Convert One Unit Quantity To Other Unit Quantity Provide By User.
     * @param quantity
     * @return : Conversion Of Unit.
     * @throws QuantityMeasurementException
     */
    @Override
    public String unitConversion(Quantity quantity) throws QuantityMeasurementException {
        try {
            if (quantity.getFirstSubUnit().getBaseUnit().equals(quantity.getSecondSubUnit().getBaseUnit())) {
                if (quantity.getFirstSubUnit().equals(UnitConversion.Celsius) && quantity.getSecondSubUnit().equals(UnitConversion.Fahrenheit)) {
                    return Double.toString((quantity.getQuantity() * quantity.getFirstSubUnit().getUnit()) + 32);
                }
                if (quantity.getFirstSubUnit().equals(UnitConversion.Fahrenheit) && quantity.getSecondSubUnit().equals(UnitConversion.Celsius)) {
                    return Double.toString((quantity.getQuantity() - 32) * quantity.getFirstSubUnit().getUnit());
                }
                return  Double.toString(quantity.getQuantity() * quantity.getFirstSubUnit().getUnit() / quantity.getSecondSubUnit().getUnit());
            } else
                throw new QuantityMeasurementException(ResponseExceptionData.TypeMisMatchException.getData());
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(ResponseExceptionData.Exception.getData());
        }
    }

    /**+
     * @purpose : This Method Used For Get List Of SubUnit With Respect To Their BaseUnits.
     * @param baseUnit
     * @return : List Of SubUnits.
     */
    @Override
    public List<UnitConversion> getSubUnits(BaseUnit baseUnit) {
            return Arrays.stream(UnitConversion.values())
                    .filter(qUnit -> qUnit.getBaseUnit().equals(baseUnit))
                    .collect(Collectors.toList());
    }

    /**+
     * @purpose : This Method This API Used For Get List Of BaseUnits.
     * @return : List Of BaseUnits.
     */
    @Override
    public List<BaseUnit> getBaseUnits() {
        return Arrays.asList(BaseUnit.values());
    }
}
