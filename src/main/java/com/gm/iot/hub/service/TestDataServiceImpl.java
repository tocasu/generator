package com.gm.iot.hub.service;

import com.gm.iot.hub.model.Data;
import com.gm.iot.hub.model.MeasurementType;
import com.gm.iot.hub.model.test.DataTestOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;

    @Override
    public void sendMessages(DataTestOptions testOptions) {
        if (testOptions.measurementTypes().length > 0) {
            executorService.scheduleAtFixedRate(() -> {
                Data data = new Data(
                        getRandomNmber(1, 10),
                        LocalDateTime.now(),
                        getRandomNmber(15, 100),
                        getRandomMeasurementType(testOptions.measurementTypes())
                );
                kafkaDataService.send(data);
            }, 0, testOptions.delaiInSeconds(), TimeUnit.SECONDS);
        }
    }

    private MeasurementType getRandomMeasurementType(MeasurementType[] measurementTypes) {
        int randomTypeId = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[randomTypeId];
    }

    private Long getRandomNmber(int min, int max) {
        return (long) ((Math.random() * (max - min)) + min);
    }
}
