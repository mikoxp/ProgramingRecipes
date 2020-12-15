package com.rabit.r;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContrl {

    @Autowired
    private RabbitSend rabbitSend;

    @Autowired
    private  Producer producer;


    @RequestMapping("/rabbit")
    public String rabbit(){
        String s = LocalDateTime.now().toString();
        rabbitSend.send(s);
        return s;
    }

    @RequestMapping("/kafka")
    public String kafka(){
        String s = LocalDateTime.now().toString();
        this.producer.sendMessage(s);
        return s;
    }
}
