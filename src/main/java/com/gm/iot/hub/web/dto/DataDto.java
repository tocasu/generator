package com.gm.iot.hub.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gm.iot.hub.model.MeasurementType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DataDto {
    Long sensorId;
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ss")
    LocalDateTime timestamp;
    double measurement;
    MeasurementType measurementType;

}
