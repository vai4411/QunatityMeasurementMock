package com.bl.quantitymeasurement.exception;

import com.bl.quantitymeasurement.enums.ResponseExceptionData;
import com.bl.quantitymeasurement.enums.ResponseMessage;
import com.bl.quantitymeasurement.model.ConversionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuantityMeasurementExceptionHandler {

    /**+
     * @purpose : When QuantityMeasurement Exception Occur Exception Handler Handle It.
     * @param quantityMeasurementException
     * @return : Response Body With Exception Message And Http Status.
     */
    @ExceptionHandler
    public ResponseEntity getNullPointerException(QuantityMeasurementException quantityMeasurementException) {
        return new ResponseEntity(new ConversionResponse(ResponseMessage.NullPointerException.getStatus(),
                ResponseMessage.NullPointerException.getMessage(),
                quantityMeasurementException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**+
     * @purpose : When Exception Occur Exception Handler Handle It.
     * @return : Response Body With Exception Message And Http Status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity getException() {
        return new ResponseEntity(new ConversionResponse(ResponseMessage.Exception.getStatus(),
                ResponseMessage.Exception.getMessage(),
                ResponseExceptionData.Exception.getData()), HttpStatus.BAD_REQUEST);
    }
}
