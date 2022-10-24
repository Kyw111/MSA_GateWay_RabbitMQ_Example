package com.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Listener {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "second.exchange", type = ExchangeTypes.TOPIC),
            value = @Queue(name = "second.queue"),
            key = "rout.key"
    ))
    public void listener(String msg) {
        System.out.println("Listener >>> " + msg);
    }
}
