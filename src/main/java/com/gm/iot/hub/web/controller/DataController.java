package com.gm.iot.hub.web.controller;

import com.gm.iot.hub.model.Data;
import com.gm.iot.hub.model.test.DataTestOptions;
import com.gm.iot.hub.service.KafkaDataService;
import com.gm.iot.hub.service.TestDataService;
import com.gm.iot.hub.web.dto.DataDto;
import com.gm.iot.hub.web.dto.DataTestOptionsDto;
import com.gm.iot.hub.web.mapper.DataMapper;
import com.gm.iot.hub.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;
    private final DataMapper mapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {
        Data data = mapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }
}
