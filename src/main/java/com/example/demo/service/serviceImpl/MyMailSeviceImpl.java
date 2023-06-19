package com.example.demo.service.serviceImpl;

import com.example.demo.service.MyMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MyMailSeviceImpl implements MyMailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public void sendMail(SimpleMailMessage simpleMailMessage) {
        try {
            javaMailSender.send(simpleMailMessage);//发送邮件
        }catch (Exception e){
        }


    }
}
