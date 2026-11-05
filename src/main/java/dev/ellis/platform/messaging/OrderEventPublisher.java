package dev.ellis.platform.messaging;

import java.util.UUID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    public OrderEventPublisher(RabbitTemplate rabbitTemplate) { this.rabbitTemplate = rabbitTemplate; }
    public void publishCreated(UUID id) {
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE,
            RabbitConfiguration.ORDER_CREATED, id.toString());
    }
}
