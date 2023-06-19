package com.example.demo.service;

import org.springframework.mail.SimpleMailMessage;

public interface MyMailService {
    void sendMail(SimpleMailMessage simpleMailMessage);
}
