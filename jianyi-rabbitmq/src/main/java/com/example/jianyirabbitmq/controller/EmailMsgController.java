package com.example.jianyirabbitmq.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jianyirabbitmq.mq.NotifyMsgProducer;
import com.example.jianyirabbitmq.vo.Mail;
import com.example.jianyirabbitmq.vo.NotifyMsgSendVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/send/email")
public class EmailMsgController {


    @Resource
    private NotifyMsgProducer notifyMsgProducer;

    /**
     * 注册
     * @return
     */
    @GetMapping("/register")
    public String sendEmail(String email,String code){
        Mail vo = new Mail();
        vo.setRecipient(email);
        vo.setCode(code);
        notifyMsgProducer.send(JSONObject.toJSONString(vo));
        return "success";
    }
    /**
     * 注册
     * @return
     */
    @GetMapping("/ceshi")
    public String ceshi(){

        return "success";
    }
}
