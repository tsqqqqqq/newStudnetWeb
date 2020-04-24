package com.example.newstudentweb.Controller;


import com.example.newstudentweb.Uilt.RestResponse;
import com.example.newstudentweb.service.Mail_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Mail_Controller {

        @Autowired
        private Mail_Service mailService;

        @RequestMapping(value = "/getCheckCode", method = RequestMethod.POST)
        public RestResponse<String> getCheckCode(String email){

            RestResponse restResponse = new RestResponse();
            String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
            String message = "您的注册验证码为："+checkCode;
            try {
                mailService.sendSimpleMail(email, "注册验证码", message);
            }catch (Exception e){
                restResponse.setData(e);
                return restResponse;
            }
            restResponse.setData(checkCode);
            System.err.println(restResponse.getData());
            return restResponse;
        }
    }


