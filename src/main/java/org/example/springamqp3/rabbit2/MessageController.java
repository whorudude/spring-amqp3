package org.example.springamqp3.rabbit2;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)

public class MessageController {
    final RabbitTemplate rabbitTemplate;

    @Value("${rabbit-config.exchange}")
    String exchange;

    @Value("${rabbit-config.routing-key}")
    String routingKey;

//    @GetMapping("/exchange")
//    public String sendToExchange(@RequestParam String message) {
//        rabbitTemplate.convertAndSend(
//                exchange,
//                routingKey,
//                message
//        );
//        return "success";
//    }

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
