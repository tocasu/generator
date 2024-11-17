package com.gm.iot.hub.model;

public enum MeasurementType {
    TEMPERATURE("data-temperature"),
    VOLTAGE("data-voltage"),
    POWER("data-power");

    private final String value;

    MeasurementType(String s) {
        this.value = s;
    }

    public String value() {
        return this.value;
    }
}
