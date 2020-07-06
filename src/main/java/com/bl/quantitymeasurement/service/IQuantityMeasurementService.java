package com.bl.quantitymeasurement.service;

import com.bl.quantitymeasurement.model.Quantity;

public interface IQuantityMeasurementService {
    long unitConversion(Quantity quantity);
}
