package com.rabit.r;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

/**
 * Sender raportu.
 */
@Service
public class RabbitSend {

    @Value("${rabbit.queue:null}")
    private String queueName;
    @Value("${rabbit.topic:null}")
    private String topic;

    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;


    public void send(String text) {
        this.rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);
        this.rabbitMessagingTemplate.convertAndSend(topic, queueName, text);
    }



}
