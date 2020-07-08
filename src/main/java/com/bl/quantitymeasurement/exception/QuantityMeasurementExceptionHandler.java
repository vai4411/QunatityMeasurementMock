package com.bl.quantitymeasurement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuantityMeasurementExceptionHandler {

    @ExceptionHandler
    public ResponseEntity getQuantityMeasurementException(QuantityMeasurementException quantityMeasurementException) {
        return new ResponseEntity(quantityMeasurementException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity getException() {
        return new ResponseEntity("Please Enter Proper Units And Quantity", HttpStatus.BAD_REQUEST);
    }
}
