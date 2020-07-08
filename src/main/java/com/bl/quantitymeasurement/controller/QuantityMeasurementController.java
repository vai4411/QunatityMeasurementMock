package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.Quantity;
import com.bl.quantitymeasurement.model.ConversionResponse;
import com.bl.quantitymeasurement.model.UnitListResponse;
import com.bl.quantitymeasurement.service.IQuantityMeasurementService;
import com.bl.quantitymeasurement.util.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService quantityMeasurementService;

    @PostMapping("/convert")
    public ResponseEntity conversion(@RequestBody Quantity quantity) throws QuantityMeasurementException {
        return new ResponseEntity(new ConversionResponse(ConstantMessage.getConversionSuccessfully,
                quantityMeasurementService.unitConversion(quantity)),HttpStatus.OK);
    }

    @GetMapping("/subUnits/{baseUnit}")
    public ResponseEntity conversion(@PathVariable BaseUnit baseUnit) {
        return new ResponseEntity(new UnitListResponse(ConstantMessage.getSubUnitListSuccessfully,
                quantityMeasurementService.getSubUnits(baseUnit)),HttpStatus.OK);
    }

    @GetMapping("/baseUnits")
    public ResponseEntity baseUnits() {
        return new ResponseEntity(new UnitListResponse(ConstantMessage.getBaseUnitListSuccessfully,
                quantityMeasurementService.getBaseUnits()),HttpStatus.OK);
    }
}
