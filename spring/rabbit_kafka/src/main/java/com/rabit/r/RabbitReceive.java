package com.rabit.r;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceive {



    @RabbitListener(queues = "${rabbit.queue:null}")
    public void receive(String info) {
        System.out.println("--RABIT-----"+info);
    }


}
