package com.example.newstudentweb.service;

import com.example.newstudentweb.entity.ID_entity;
import com.example.newstudentweb.mapper.users_Mapper;
import com.example.newstudentweb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class users_Service {

        @Autowired
        private users_Mapper users_mapper;

        @Autowired
        private com.example.newstudentweb.Uilt.certificateUtilt certificateUtilt;

        @Autowired
        private ID_entity id_entity;

        @Autowired
        private Student_service student_service;


    /**
     * 插入修改密码后的学生登陆信息到users表
     * @param studentPassWord
     * @param student
     * @return
     */
        public boolean userInsert(String studentPassWord, Student student)
        {
            boolean b = student_service.StudentInfo(student);

            String studentIdNum = student.getStudentIdNum();
            return b? users_mapper.userInsert(studentIdNum,studentPassWord):false;
        }

    /**
     * 修改user表中对应账号的密码
     * @param studentIdNum
     * @param studentPassWord
     * @return
     */
    public boolean updatePass(String studentIdNum,String studentPassWord)
    {
            return users_mapper.updatePass(studentIdNum,studentPassWord);
    }

}
