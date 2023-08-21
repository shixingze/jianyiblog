package com.example.jianyirabbitmq.mq;

import com.example.jianyirabbitmq.base.ExchangeName;
import com.example.jianyirabbitmq.base.RoutingKeyName;
import com.example.jianyirabbitmq.vo.NotifyMsgSendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class NotifyMsgProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;


    public void send(String msg) {
        log.debug("生产消息【{}】",msg);
        this.rabbitTemplate.convertAndSend(ExchangeName.NOTIFY_MSG.name(),
                RoutingKeyName.NOTIFY_MSG.name(), msg);
    }
}
