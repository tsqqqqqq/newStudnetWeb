package com.example.newstudentweb.Controller;

import com.example.newstudentweb.service.Login_Service;
import com.example.newstudentweb.model.Admin;
import com.example.newstudentweb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class Login_Controller {

    @Autowired
    private Login_Service login_service;

    /**
     * 管理员登陆
     * @param admin
     * @return
     */
    @RequestMapping("/adminLogin")
    public Admin adminLogin(Admin admin)
    {
            return (admin==null)?null:login_service.adminLogin(admin);
    }

    /**
     * 学生登陆控制
     * @param studentIdNum
     * @param studentPassWord
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/studentLoginController")
    public ModelAndView studentLoginController(String studentIdNum, String studentPassWord, RedirectAttributes redirectAttributes)
    {

        redirectAttributes.addAttribute("studentIdNum",studentIdNum);
        redirectAttributes.addAttribute("studentPassWord",studentPassWord);

        return new ModelAndView(login_service.studentLoginControllerService(studentIdNum));
    }

    /**
     * 已修改过密码的学生登陆
     * @param studentIdNum
     * @param studentPassWord
     * @return
     */
    @RequestMapping("/studentLogin")
    public Student studentLogin(String studentIdNum,String studentPassWord)
    {

        return login_service.studentLogin(studentIdNum,studentPassWord);
    }

    /**
     * 未修改密码的学生登陆
     * @param studentIdNum
     * @param studentPassWord
     * @return
     */
    @RequestMapping("/studentLoginInFo")
    public Student studentLoginInFo(String studentIdNum,String studentPassWord)
    {
        return login_service.studentLoginInfo(studentIdNum,studentPassWord);
    }


    /**
     * 检查是否存在改登陆账号
     * @param studentIdNum
     * @return
     */
    @RequestMapping("/checkIdNum")
    public boolean checkIdNum(String studentIdNum) {

        Student student = login_service.checkIdNum(studentIdNum);
        if (student != null) {

            return true;
        } else {
            return false;
        }
    }
}
