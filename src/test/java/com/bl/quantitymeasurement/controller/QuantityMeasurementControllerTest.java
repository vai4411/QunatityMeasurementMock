package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.model.Quantity;
import com.bl.quantitymeasurement.model.Response;
import com.bl.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class QuantityMeasurementControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    private QuantityMeasurementController quantityMeasurementController;

    @Mock
    private QuantityMeasurementServiceImpl quantityMeasurementServiceImpl;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(quantityMeasurementController, "quantityMeasurementService",
                quantityMeasurementServiceImpl);
        mockMvc = MockMvcBuilders.standaloneSetup(quantityMeasurementController)
                .build();
    }

    @Test
    public void givenQuantityMeasurement_WhenCallBaseUnit_ThenReturnListOfUnits() throws Exception {
        List<BaseUnit> units = new ArrayList<>();
        units.add(BaseUnit.Length);
        units.add(BaseUnit.Weight);
        units.add(BaseUnit.Temperature);
        units.add(BaseUnit.Volume);
        Mockito.when(quantityMeasurementServiceImpl.getBaseUnits()).thenReturn(units);
        String data = mapper.writeValueAsString(units);
        MvcResult result = mockMvc.perform(get("/quantity/baseUnits"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(data,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneFeetConvertIntoInch_ThenReturnTwelveInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Feet);
        quantity.setSecondSubUnit(UnitConversion.Inch);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 12.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(12.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenCallSubUnitOfLength_ThenReturnListOfUnits() throws Exception {
        List<UnitConversion> units = new ArrayList<>();
        units.add(UnitConversion.Feet);
        units.add(UnitConversion.Inch);
        Mockito.when(quantityMeasurementServiceImpl.getSubUnits(Mockito.any())).thenReturn(units);
        String data = mapper.writeValueAsString(units);
        MvcResult result = mockMvc.perform(get("/quantity/subUnits/Length"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(data,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneYardConvertToInch_ThenReturnThirtySixInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Yard);
        quantity.setSecondSubUnit(UnitConversion.Inch);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 36.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(36.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenFiveCMConvertToInch_ThenReturnTwoInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(5);
        quantity.setFirstSubUnit(UnitConversion.Centimeter);
        quantity.setSecondSubUnit(UnitConversion.Inch);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 2.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(2.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenTwoInchConvertToCM_ThenReturnFiveInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(2);
        quantity.setFirstSubUnit(UnitConversion.Inch);
        quantity.setSecondSubUnit(UnitConversion.Centimeter);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 5.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(5.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenYardConvertToCM_ThenReturnNinetyInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Inch);
        quantity.setSecondSubUnit(UnitConversion.Centimeter);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 90.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(90.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneFeetConvertToCM_ThenReturnThirtyInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Feet);
        quantity.setSecondSubUnit(UnitConversion.Centimeter);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 30.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(30.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenTwelveInchConvertToFeet_ThenReturnOneInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(12);
        quantity.setFirstSubUnit(UnitConversion.Feet);
        quantity.setSecondSubUnit(UnitConversion.Centimeter);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 1.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(1.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneYardConvertToFeet_ThenReturnThreeInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Yard);
        quantity.setSecondSubUnit(UnitConversion.Feet);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 3.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(3.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneKGConvertToGM_ThenReturnThousandInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Kilogram);
        quantity.setSecondSubUnit(UnitConversion.Gram);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 1000.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(1000.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenThousandKGConvertToTonne_ThenReturnOneInResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1000);
        quantity.setFirstSubUnit(UnitConversion.Kilogram);
        quantity.setSecondSubUnit(UnitConversion.Tonne);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 1.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(1.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenOneTonneConvertToKG_ThenReturnThousandResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Tonne);
        quantity.setSecondSubUnit(UnitConversion.Kilogram);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 1000.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(1000.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenZeroPointZeroZeroOneTonneConvertToGM_ThenReturnThousandResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(0.001);
        quantity.setFirstSubUnit(UnitConversion.Tonne);
        quantity.setSecondSubUnit(UnitConversion.Gram);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 1000.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(1000.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenLitreConvertToML_ThenReturnThousandResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Litre);
        quantity.setSecondSubUnit(UnitConversion.Millilitre);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 1000.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(1000.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }


    @Test
    public void givenQuantityMeasurement_WhenOneLitreConvertToGallon_ThenReturnThreePointSeventyEightResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setFirstSubUnit(UnitConversion.Litre);
        quantity.setSecondSubUnit(UnitConversion.Gallon);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 3.78));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(3.78);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenThousandMLConvertToLitre_ThenReturnOneResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1000);
        quantity.setFirstSubUnit(UnitConversion.Millilitre);
        quantity.setSecondSubUnit(UnitConversion.Litre);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 1.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(1.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenThousandMLConvertToGallon_ThenReturnThreePointSeventyEightResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1000);
        quantity.setFirstSubUnit(UnitConversion.Millilitre);
        quantity.setSecondSubUnit(UnitConversion.Gallon);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 3.78));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(3.78);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenHundredCelsiusConvertToFahrenheit_ThenReturnTwoHundredTwelveResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(100);
        quantity.setFirstSubUnit(UnitConversion.Celsius);
        quantity.setSecondSubUnit(UnitConversion.Fahrenheit);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 212.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(212.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }

    @Test
    public void givenQuantityMeasurement_WhenTwoHundredTwelveFahrenheitConvertToCelsius_ThenReturnHundredResponse() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(212);
        quantity.setFirstSubUnit(UnitConversion.Celsius);
        quantity.setSecondSubUnit(UnitConversion.Fahrenheit);
        String response = mapper.writeValueAsString(new Response("Unit Converted Successfully", 100.0));
        Mockito.when(quantityMeasurementServiceImpl.unitConversion(Mockito.any())).thenReturn(100.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(post("/quantity/convertSubUnitsNames")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(response,content);
    }
}
