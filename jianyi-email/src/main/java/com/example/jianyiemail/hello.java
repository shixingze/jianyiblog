package com.example.jianyiemail;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class hello {
    public static void main(String[] args) {
        String to = "748762024@qq.com";
        String from = "1731150369@qq.com";
        String host = "smtp.qq.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host",host);
        properties.put("mail.smtp.auth","true");


        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("393803933","***********");
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            mimeMessage.setSubject("主题：黑客笔记");
            mimeMessage.setText("正文：我是ailx10，我喜欢2进制安全和渗透技术");
            Transport.send(mimeMessage);
            System.out.println("发送邮件成功");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}