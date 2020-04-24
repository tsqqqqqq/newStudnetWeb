package com.example.newstudentweb.service;


import com.example.newstudentweb.entity.ID_entity;
import com.example.newstudentweb.entity.MD5_entity;
import com.example.newstudentweb.mapper.Login_Mapper;
import com.example.newstudentweb.Uilt.certificateUtilt;
import com.example.newstudentweb.model.Admin;
import com.example.newstudentweb.model.Student;
import com.example.newstudentweb.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Service
@Transactional(propagation = Propagation.REQUIRED , isolation =  Isolation.DEFAULT)
public class Login_Service extends MD5_entity {

    @Autowired
    private Login_Mapper login_mapper;

    @Autowired
    private certificateUtilt certificateUtilt;

    @Autowired
    private ID_entity id_entity;

    /**
     * 管理员登陆
     * @param admin
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS , isolation =  Isolation.DEFAULT , readOnly = true)
    public Admin adminLogin(Admin admin)
    {
        admin.setAdminPassWord(string2MD5(admin.getAdminPassWord(),true));

        return (admin==null) ? null: login_mapper.AdminLogin(admin);
    };

    /**
     * 学生登陆控制
     * @param studentIdNum
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS , isolation =  Isolation.DEFAULT , readOnly = true)
    public String studentLoginControllerService(String studentIdNum)
    {

        HashMap<String , Object> map = certificateUtilt.getBirAgeSex(studentIdNum);
        String birth = id_entity.birthString((String) map.get("birthday"));

        String word = id_entity.keyEntity(birth);
        String IdNum=studentIdNum.replaceAll(birth,word);

       int InFo = login_mapper.StudentInfo(IdNum);

        return (InFo>0)? "redirect:studentLogin":"redirect:studentLoginInFo";
    }

    /**
     * 未修改密码的学生登陆
     * @param studentIdNum
     * @param studentPassWord
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS , isolation =  Isolation.DEFAULT , readOnly = true)
    public Student studentLoginInfo(String studentIdNum,String studentPassWord)
    {
        HashMap<String , Object> map = certificateUtilt.getBirAgeSex(studentIdNum);
        String birth = id_entity.birthString((String) map.get("birthday"));


        if(string2MD5(string2MD5(birth,false),true).equals(string2MD5(studentPassWord,true))||
                string2MD5(string2MD5(birth,false),true)==string2MD5(studentPassWord,true))
        {

            String word = id_entity.keyEntity(birth);
            String IdNum = studentIdNum.replaceAll(birth,word);
            return login_mapper.StudentIdNum(IdNum);
        }
        else
        {
            return null;
        }

    }

    /**
     * 查询身份证号是否存在
     * @param studentIdNum
     * @return
     */
    public Student checkIdNum(String studentIdNum)
    {

        HashMap<String , Object> map = certificateUtilt.getBirAgeSex(studentIdNum);
        String birth = id_entity.birthString((String) map.get("birthday"));
        String word = id_entity.keyEntity(birth);
        String IdNum = studentIdNum.replaceAll(birth,word);

        return login_mapper.StudentIdNum(IdNum);
    }

    /**
     * 已修改默认密码的学生登陆
     */
    public Student studentLogin(String studentIdNum,String studentPassWord)
    {

        HashMap<String , Object> map = certificateUtilt.getBirAgeSex(studentIdNum);
        String birth = id_entity.birthString((String) map.get("birthday"));
        String word = id_entity.keyEntity(birth);
        String IdNum = studentIdNum.replaceAll(birth,word);
        String Id= login_mapper.UsersLogin(IdNum, studentPassWord);
        return login_mapper.StudentIdNum(Id);
    }


}
