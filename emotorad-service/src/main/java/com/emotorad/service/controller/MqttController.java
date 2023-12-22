package com.emotorad.service.controller;


import com.emotorad.service.dto.MessageDto;
import com.emotorad.service.service.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MqttController {

    @Autowired
    MqttService mqttService;

    @PostMapping("/postMessage")
    public void postMessage(MessageDto messageDto) {
        mqttService.postMessage(messageDto);

    }

    @GetMapping("/getMessage")
    public List<MessageDto> getMessage() {
       return  mqttService.getMessage();

    }
}
