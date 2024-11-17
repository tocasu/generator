package com.gm.iot.hub.service;

import com.gm.iot.hub.model.Data;

public interface KafkaDataService {

    void send(Data data);
}
