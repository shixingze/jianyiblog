package com.example.jianyirabbitmq.mq;

import com.alibaba.fastjson.JSONObject;
import com.example.jianyirabbitmq.base.QueueNames;
import com.example.jianyirabbitmq.vo.Mail;
import com.example.jianyirabbitmq.vo.NotifyMsgSendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class NotifyMsgConsumer {



    @Autowired
    private RestTemplate restTemplate;
        public static final String EMAIL = "http://JIANYI-EMAIL";

    @RabbitListener(queues = QueueNames.NOTIFY_MSG_QUEUE)
    public void msgSend(String vo) {
      Mail mail = JSONObject.parseObject(vo,Mail.class);
      System.out.println("消费者收到消息:"+vo);
        String url= "/email/model/register?email="+mail.getRecipient()+"&code="+mail.getCode();
        restTemplate.getForObject(EMAIL + url,String.class );
        log.debug("发送成功");
    }
}
