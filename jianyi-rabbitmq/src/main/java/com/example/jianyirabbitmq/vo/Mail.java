package com.example.jianyirabbitmq.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Mail implements Serializable {
    private static final long serialVersionUID = 4359709211352400087L;
    private String recipient;//邮件接收人
    private String type; //邮件类型
    private String code; //邮件验证码
    private String content;
    private String subject;
}
