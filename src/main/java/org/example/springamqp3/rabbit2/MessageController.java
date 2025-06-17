package org.example.springamqp3.rabbit2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbit-config.exchange}")
    private String exchange;

    @Value("${rabbit-config.routing-key}")
    private String routingKey;

    @Autowired
    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/exchange")
    public String sendToExchange(@RequestBody MessageObject messageObject) {
        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                messageObject
        );

        return "success";
    }
}
