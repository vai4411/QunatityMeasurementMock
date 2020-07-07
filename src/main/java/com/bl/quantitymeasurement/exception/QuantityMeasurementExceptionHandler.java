package com.bl.quantitymeasurement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuantityMeasurementExceptionHandler {

    @ExceptionHandler
    public ResponseEntity getException(QuantityMeasurementException quantityMeasurementException) {
        return new ResponseEntity(quantityMeasurementException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity getException() {
        return new ResponseEntity("Null Or Empty Values Not Accepted", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
