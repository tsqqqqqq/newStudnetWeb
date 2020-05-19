package com.example.newstudentweb.ToPageController;

import com.example.newstudentweb.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopageController {


//        @RequestMapping("/{path}")
//        public String toPage(@PathVariable("path") String path)
//        {
//            return  path;
//        };
    public void fun(){
        Admin admin  = new Admin();
        admin.setAdminUsers("abc");//相当于 adminUsers = 'abc' 赋值语句
        admin.getAdminUsers();//
    }
}
