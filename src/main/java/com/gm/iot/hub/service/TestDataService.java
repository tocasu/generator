package com.gm.iot.hub.service;

import com.gm.iot.hub.model.test.DataTestOptions;

public interface TestDataService {
    void sendMessages(DataTestOptions dataTestOptions);
}
