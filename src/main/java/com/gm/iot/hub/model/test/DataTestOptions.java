package com.gm.iot.hub.model.test;

import com.gm.iot.hub.model.MeasurementType;

public record DataTestOptions(int delaiInSeconds, MeasurementType[] measurementTypes) {
}
