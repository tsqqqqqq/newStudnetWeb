package com.example.newstudentweb.Controller;

import com.example.newstudentweb.model.Student;
import com.example.newstudentweb.service.Student_service;
import com.example.newstudentweb.service.users_Service;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Users_Controller {

    @Autowired
    private users_Service users_service;

    @Autowired
    private Student_service student_service;

    /**
     * 修改密码后的学生登录信息存入user表中
     * @param password
     * @param
     * @return
     */
    @RequestMapping("/userInsert")
    public boolean userInsert(String password, String studentPhone,String studentEmail, int studentId)
    {
            Student student =student_service.showStudent(studentId);
            student.setStudentPhone(studentPhone);
            student.setStudentEmail(studentEmail);

        return users_service.userInsert(password,student);
    }

    /**
     * 修改user表中对应账号的密码
     * @param IdNum
     * @param IdNum
     * @return
     */
    @RequestMapping("/userPass")
    public boolean updatePass(String IdNum,String password)
    {
        return users_service.updatePass(IdNum,password);
    }
}
