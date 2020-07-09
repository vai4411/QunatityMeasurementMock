package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.enums.BaseUnit;
import com.bl.quantitymeasurement.enums.ResponseMessage;
import com.bl.quantitymeasurement.exception.QuantityMeasurementException;
import com.bl.quantitymeasurement.model.ConversionResponse;
import com.bl.quantitymeasurement.model.Quantity;
import com.bl.quantitymeasurement.model.UnitListResponse;
import com.bl.quantitymeasurement.service.IQuantityMeasurementService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    Logger log = LoggerFactory.getLogger(QuantityMeasurementController.class);

    @Autowired
    private IQuantityMeasurementService quantityMeasurementService;

    @Autowired
    MessageSource messageSource;

    /**+
     * @purpose : This API Used For The Convert One Unit Quantity To Other Unit Quantity Provide By User.
     * @param quantity
     * @return : Response With Quantity Conversion And Http Status.
     * @throws QuantityMeasurementException
     */
    @ApiOperation("Convert One Unit To Another Unit")
    @PostMapping("/convert")
    public ResponseEntity conversion(@RequestBody Quantity quantity) throws QuantityMeasurementException {
        log.debug("Inside The Unit Conversion API");
        log.debug("Request {}", quantity);
        return new ResponseEntity(new ConversionResponse(ResponseMessage.ConversionSuccess.getStatus(),
                ResponseMessage.ConversionSuccess.getMessage(),
                quantityMeasurementService.unitConversion(quantity)),HttpStatus.OK);
    }

    /**+
     * @purpose : This API Used For Get List Of SubUnit With Respect To Their BaseUnits.
     * @param unit
     * @return : Response With List Of SubUnits And Http Status.
     */
    @ApiOperation("Get List Of Sub Units With Respect To Base Unit")
    @GetMapping("/sub_units/{unit}")
    public ResponseEntity conversion(@PathVariable BaseUnit unit) {
        log.debug("Inside The SubUnit API");
        log.debug("Request {}", unit);
        return new ResponseEntity(new UnitListResponse(ResponseMessage.SubUnitSuccess.getStatus(),
                ResponseMessage.SubUnitSuccess.getMessage(),
                quantityMeasurementService.getSubUnits(unit)),HttpStatus.OK);
    }

    /**+
     * @purpose : This API Used For Get List Of BaseUnits.
     * @return : Response With List Of BaseUnits And Http Status.
     */
    @ApiOperation("Get List Of Base Units")
    @GetMapping("/base_units")
    public ResponseEntity baseUnits() {
        log.debug("Inside The BaseUnit API");
        return new ResponseEntity(new UnitListResponse(ResponseMessage.SubUnitSuccess.getStatus(),
                ResponseMessage.BaseUnitSuccess.getMessage(),
                quantityMeasurementService.getBaseUnits()),HttpStatus.OK);
    }
}
