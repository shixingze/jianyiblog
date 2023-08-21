package com.example.jianyiemail.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jianyiemail.baen.Mail;
import com.example.jianyiemail.enums.MailContentTypeEnum;
import com.example.jianyiemail.utils.MailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import java.util.ArrayList;

@RestController
@RequestMapping("/email/model")
public class EmailController {



    /**
     * 注册
     * @return
     */
    @GetMapping("/register")
    public String send(String email,String code) throws Exception {

            new MailSender()
                    .title("【jainyi】注册验证码")
                    .content(code)
                    .contentType(MailContentTypeEnum.TEXT)
                    .targets(new ArrayList<String>(){{
                        add(email);
                    }})
                    .send();
            Thread.sleep(1000);
            System.out.println("第"+"次发送成功!");

      return "发送成功";
    }
}
