package com.emotorad.service.service;

import com.emotorad.service.dto.MessageDto;
import com.emotorad.service.mqtt.MqttMessageProducer;
import com.emotorad.service.repo.MessageRepository;
import com.emotorad.service.repo.entity.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MqttService {

    @Autowired
    MqttMessageProducer mqttMessageProducer;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ObjectMapper objectMapper;
    public void postMessage(MessageDto messageDto){
        try {
            mqttMessageProducer.sendToMqtt(objectMapper.writeValueAsString(messageDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MessageDto> getMessage() {
        List<Message> messages = (List) messageRepository.findAll();
        List<MessageDto> collect = messages.stream().map(m -> {
            MessageDto dto = new MessageDto();
            dto.setSpeed(m.getSpeed());
            return dto;
        }).collect(Collectors.toList());
        return collect;
    }
}
