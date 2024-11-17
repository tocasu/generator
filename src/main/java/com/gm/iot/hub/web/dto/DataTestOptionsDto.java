package com.gm.iot.hub.web.dto;

import com.gm.iot.hub.model.MeasurementType;

public record DataTestOptionsDto(int delaiInSeconds, MeasurementType[] measurementTypes) {
}
