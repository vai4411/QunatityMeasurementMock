package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.model.Quantity;
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
    public ResponseEntity<Long> conversion(@RequestBody Quantity quantity) {
        long result = quantityMeasurementService.unitConversion(quantity);
        return new ResponseEntity<> (result, HttpStatus.OK);
    }


}
