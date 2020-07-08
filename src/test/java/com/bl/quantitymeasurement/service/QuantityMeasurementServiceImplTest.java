package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;
import com.bl.quantitymeasurement.util.ConstantMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class QuantityMeasurementServiceImplTest {

    @InjectMocks
    QuantityMeasurementServiceImpl quantityMeasurementService;

    @Test
    public void givenQuantityMeasurement_WhenCallBaseUnit_ThenReturnListOfUnits() {
        List<BaseUnit> units = new ArrayList<>();
        units.add(BaseUnit.Length);
        units.add(BaseUnit.Weight);
        units.add(BaseUnit.Volume);
        units.add(BaseUnit.Temperature);
        Assert.assertEquals(units,quantityMeasurementService.getBaseUnits());
    }

    @Test
    public void givenQuantityMeasurement_WhenCallSubBaseUnitOfLength_ThenReturnListOfUnits() {
        List<UnitConversion> units = new ArrayList<>();
        units.add(UnitConversion.Feet);
        units.add(UnitConversion.Inch);
        units.add(UnitConversion.Yard);
        units.add(UnitConversion.Centimeter);
        List baseUnits = quantityMeasurementService.getSubUnits(BaseUnit.Length);
        Assert.assertEquals(units,baseUnits);
    }

    @Test
    public void givenQuantityMeasurement_WhenCallSubBaseUnitOfWeight_ThenReturnListOfUnits() {
        List<UnitConversion> units = new ArrayList<>();
        units.add(UnitConversion.Kilogram);
        units.add(UnitConversion.Gram);
        units.add(UnitConversion.Tonne);
        List baseUnits = quantityMeasurementService.getSubUnits(BaseUnit.Weight);
        Assert.assertEquals(units,baseUnits);
    }

    @Test
    public void givenQuantityMeasurement_WhenCallSubBaseUnitOfVolume_ThenReturnListOfUnits() {
        List<UnitConversion> units = new ArrayList<>();
        units.add(UnitConversion.Litre);
        units.add(UnitConversion.Gallon);
        units.add(UnitConversion.Millilitre);
        List baseUnits = quantityMeasurementService.getSubUnits(BaseUnit.Volume);
        Assert.assertEquals(units,baseUnits);
    }

    @Test
    public void givenQuantityMeasurement_WhenCallSubBaseUnitOfTemperature_ThenReturnListOfUnits() {
        List<UnitConversion> units = new ArrayList<>();
        units.add(UnitConversion.Celsius);
        units.add(UnitConversion.Fahrenheit);
        List baseUnits = quantityMeasurementService.getSubUnits(BaseUnit.Temperature);
        Assert.assertEquals(units,baseUnits);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneFeetConvertIntoInch_ThenReturnTwelve() throws QuantityMeasurementException {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Feet);
        quantity.setSecondSubUnit(UnitConversion.Inch);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(12.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneYardConvertToInch_ThenReturnThirtySix() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Yard);
        quantity.setSecondSubUnit(UnitConversion.Inch);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(36,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenFiveCMConvertToInch_ThenReturnTwo() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(5);
        quantity.setFirstSubUnit(UnitConversion.Centimeter);
        quantity.setSecondSubUnit(UnitConversion.Inch);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(2.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenTwoInchConvertToCM_ThenReturnFive() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(2);
        quantity.setFirstSubUnit(UnitConversion.Inch);
        quantity.setSecondSubUnit(UnitConversion.Centimeter);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(5.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenYardConvertToCM_ThenReturnNinety() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Yard);
        quantity.setSecondSubUnit(UnitConversion.Centimeter);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(90.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneFeetConvertToCM_ThenReturnThirty() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Feet);
        quantity.setSecondSubUnit(UnitConversion.Centimeter);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(30.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenTwelveInchConvertToFeet_ThenReturnOne() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(12);
        quantity.setFirstSubUnit(UnitConversion.Inch);
        quantity.setSecondSubUnit(UnitConversion.Feet);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(1.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneYardConvertToFeet_ThenReturnThree() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Yard);
        quantity.setSecondSubUnit(UnitConversion.Feet);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(3.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenHundredCelsiusConvertIntoFahrenheit_ThenReturnTwoHundredTwelve() throws QuantityMeasurementException {
        Quantity quantity = new Quantity();
        quantity.setQuantity(100);
        quantity.setFirstSubUnit(UnitConversion.Celsius);
        quantity.setSecondSubUnit(UnitConversion.Fahrenheit);
        double result = quantityMeasurementService.unitConversion(quantity);
        Assert.assertEquals(212.0,result,0.0);
    }

    @Test
    public void givenQuantityMeasurement_WhenTwoDifferentBaseUnitsPassInRequest_ThenThrowException() {
        try {
            Quantity quantity = new Quantity();
            quantity.setQuantity(1);
            quantity.setFirstSubUnit(UnitConversion.Feet);
            quantity.setSecondSubUnit(UnitConversion.Kilogram);
            quantityMeasurementService.unitConversion(quantity);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(ConstantMessage.getConversionFailException,e.getMessage());
        }
    }
}
