package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.SubUnits;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.model.Quantity;
import com.bl.quantitymeasurement.service.QuantityMeasurementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class QuantityMeasurementControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    private QuantityMeasurementController quantityMeasurementController;

    @Mock
    private QuantityMeasurementService quantityMeasurementService;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(quantityMeasurementController, "quantityMeasurementService",
                                    quantityMeasurementService);
        mockMvc = MockMvcBuilders.standaloneSetup(quantityMeasurementController)
                .build();
    }

    @Test
    public void givenQuantityMeasurement_WhenRequestPassSuccessfully_ThenReturnValueOfUnit() throws Exception {
        Quantity quantity = new Quantity();
        quantity.setQuantity(1);
        quantity.setBaseUnit(BaseUnit.Length.getUnit());
        quantity.setFirstSubUnit(UnitConversion.Feet.getUnit());
        quantity.setSecondSubUnit(UnitConversion.Inch.getUnit());
        Mockito.when(quantityMeasurementService.unitConversion(Mockito.any())).thenReturn((long) 12.0);
        String data = mapper.writeValueAsString(quantity);
        MvcResult result = mockMvc.perform(get("/quantity/convert")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(data))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        long value = Long.parseLong(content);
        Assert.assertEquals(12,value);
    }


}
