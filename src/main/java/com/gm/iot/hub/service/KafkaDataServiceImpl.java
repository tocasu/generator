package com.gm.iot.hub.service;

import com.gm.iot.hub.model.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final KafkaSender<String, Object> kafkaSender;

    @Override
    public void send(Data data) {
        String topic = data.getMeasurementType().value();
        kafkaSender.send(Mono.just(
                SenderRecord.create(topic, 0, System.currentTimeMillis(), String.valueOf(data.hashCode()), data, null)
        )).subscribe();
    }
}
