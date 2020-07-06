package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuantityMeasurementServiceImplTest {

    @InjectMocks
    QuantityMeasurementServiceImpl quantityMeasurementService;

    @Test
    public void givenQuantityMeasurement_WhenOneFeetConvertIntoInch_ThenReturnTwelve() throws QuantityMeasurementException {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setBaseUnit(BaseUnit.Length);
        quantity.setFirstSubUnit(UnitConversion.Feet);
        quantity.setSecondSubUnit(UnitConversion.Inch);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(12.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenTwoDifferentBaseUnits_ThenThrowException() throws QuantityMeasurementException {
        try {
            Quantity quantity = new Quantity();
            quantity.setQuantity(1);
            quantity.setBaseUnit(BaseUnit.Length);
            quantity.setFirstSubUnit(UnitConversion.Feet);
            quantity.setSecondSubUnit(UnitConversion.KG);
            double result = quantityMeasurementService.unitConversion(quantity);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals("Base Units Not Matches",e.getMessage());
        }
    }
}
