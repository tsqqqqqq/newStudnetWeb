package com.example.newstudentweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class Mail_Service {


        @Value("${spring.mail.username}")
        private String from;

        @Autowired
        private JavaMailSender javaMailSender;

        public void sendSimpleMail(String to,String title,String content){

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            System.err.println(from);
            mailMessage.setTo(to);
            System.err.println(to);
            mailMessage.setSubject(title);
            System.err.println(title);
            mailMessage.setText(content);
            System.err.println(content);
            javaMailSender.send(mailMessage);
            System.err.println("邮件发送成功");
        }
    }

