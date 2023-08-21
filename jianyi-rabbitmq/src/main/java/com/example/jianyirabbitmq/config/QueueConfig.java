package com.example.jianyirabbitmq.config;

import com.example.jianyirabbitmq.base.ExchangeName;
import com.example.jianyirabbitmq.base.QueueNames;
import com.example.jianyirabbitmq.base.RoutingKeyName;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(ExchangeName.DEFAULT.name());
    }

    @Bean
    public DirectExchange notifyMsgDirectExchange() {
        return new DirectExchange(ExchangeName.NOTIFY_MSG.name());
    }

    @Bean
    public Queue notifyMsgQueue() {
        return new Queue(QueueNames.NOTIFY_MSG_QUEUE, true);
    }


    @Bean
    public Binding notifyMsgQueueBinding() {
        return BindingBuilder
                .bind(notifyMsgQueue())
                .to(notifyMsgDirectExchange())
                .with(RoutingKeyName.NOTIFY_MSG);
    }
}
