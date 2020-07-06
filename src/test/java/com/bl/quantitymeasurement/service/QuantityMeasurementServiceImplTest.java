package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void givenQuantityMeasurement_WhenTwoDifferentBaseUnits_ThenThrowException() {
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

    @Test
    public void givenQuantityMeasurement_WhenOneCelsiusConvertIntoFahrenheit_ThenReturnThirtyThreePointEight() throws QuantityMeasurementException {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setBaseUnit(BaseUnit.Temperature);
        quantity.setFirstSubUnit(UnitConversion.Celsius);
        quantity.setSecondSubUnit(UnitConversion.Fahrenheit);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(33.8,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenCallBaseUnit_ThenReturnListOfUnits() {
        List<BaseUnit> units = new ArrayList<>();
        units.add(BaseUnit.Length);
        units.add(BaseUnit.Weight);
        units.add(BaseUnit.Volume);
        units.add(BaseUnit.Temperature);
        List baseUnits = quantityMeasurementService.getBaseUnits();
        Assert.assertEquals(units,baseUnits);
    }
}
