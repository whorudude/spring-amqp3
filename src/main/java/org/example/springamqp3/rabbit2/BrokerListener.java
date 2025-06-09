package org.example.springamqp3.rabbit2;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class BrokerListener {

    @RabbitListener(queues = "${rabbit-config.queue}")
    public void receiveMessage(@Payload MessageObject message) {
        log.info("Received message {}", message);
    }
}
