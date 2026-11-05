package dev.ellis.platform.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    public static final String EXCHANGE = "platform.events";
    public static final String ORDER_CREATED = "order.created";
    public static final String QUEUE = "platform.order.created";

    @Bean DirectExchange platformExchange() { return new DirectExchange(EXCHANGE, true, false); }
    @Bean Queue orderCreatedQueue() { return new Queue(QUEUE, true); }
    @Bean Binding createdBinding(Queue orderCreatedQueue, DirectExchange platformExchange) {
        return BindingBuilder.bind(orderCreatedQueue).to(platformExchange).with(ORDER_CREATED);
    }
}
