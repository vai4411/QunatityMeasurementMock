package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.UnitConversion;
import com.bl.quantitymeasurement.model.Quantity;
import com.bl.quantitymeasurement.model.Response;
import com.bl.quantitymeasurement.service.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    @Autowired
    private QuantityMeasurementService quantityMeasurementService;

    @GetMapping("/convert")
    public ResponseEntity conversion(@RequestBody Quantity quantity) {
        return new ResponseEntity(new Response("Unit Converted Successfully",
                quantityMeasurementService.unitConversion(quantity)),HttpStatus.OK);
    }

    @GetMapping("/subUnits/{baseUnit}")
    public List<UnitConversion> conversion(@PathVariable BaseUnit baseUnit) {
        List<UnitConversion> result = quantityMeasurementService.getSubUnits(baseUnit);
        return result;
    }

    @GetMapping("/baseUnits")
    public List<BaseUnit> baseUnits() {
        List<BaseUnit> result = quantityMeasurementService.getBaseUnits();
        return result;
    }
}
