package com.emotorad.service.mqtt;

import com.emotorad.service.dto.MessageDto;
import com.emotorad.service.repo.MessageRepository;
import com.emotorad.service.repo.UserRepository;
import com.emotorad.service.repo.entity.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import java.util.List;

@MessageEndpoint
public class MqttMessageConsumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(String message) {
        System.out.println("Received message: " + message);
        try {
            Message eMessage = objectMapper.readValue(message, Message.class);
            List<Message> messageDtos = (List<Message>) messageRepository.findAll();
            if (messageDtos.stream().findFirst().isPresent()) {
                messageDtos.stream().findFirst().ifPresent(m -> {
                    m.setSpeed(eMessage.getSpeed());
                    messageRepository.save(m);
                });
            } else {
                messageRepository.save(eMessage);
            }


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
