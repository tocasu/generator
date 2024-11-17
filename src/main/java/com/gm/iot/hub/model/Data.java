package com.gm.iot.hub.model;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Data {

    private Long sensorId;
    private LocalDateTime timestamp;
    private double measurement;
    private MeasurementType measurementType;

}
