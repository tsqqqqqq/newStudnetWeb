package com.example.newstudentweb.Controller;


import com.example.newstudentweb.service.Student_service;
import com.example.newstudentweb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class Student_Controller {

        @Autowired
        private Student_service student_service;

    /**
     * 分页查询学生列表
     * @param pageNo 页数
     * @param pageSize 查询熟练
     * @return
     */
        @RequestMapping("/studentList")
        public List<Student> studentList(int pageNo , int pageSize)
        {

            return student_service.StudentList(pageNo,pageSize);
        }

        /**
         * 录入学生信息 单人版
         * @param student
         * @return
         */
        @RequestMapping("/studentAdd")
        public boolean studentAdd(Student student)
        {

            return (student!=null)? student_service.studentAdd(student):false;
        }

        /**
         * 录入学生信息 exel版
         */


    /**
     * 根据学生Id 查询学生信息
     * @param studentId
     * @return
     */
        @RequestMapping("/showStudent")
        public Student showStudent(int studentId)
        {
            return student_service.showStudent(studentId);
        }


    /**
     * 查询某一专业录取的学生数量
     * @param majorId
     * @return
     */
    @RequestMapping("/studentNumber")
        public int studentNumber(int majorId)
        {
            return student_service.studentNumber(majorId);
        }

    /**
     * 校验登陆学生的准考证号
     * @param ExamNum
     * @return
     */
    @RequestMapping("/studentExamNum")
     public boolean studentExamNum(String ExamNum,String IdNum){
        return student_service.StudentExamNum(ExamNum,IdNum);
    }

    /**
     * 学生激活
     * @param stduent
     * @return
     */
    @RequestMapping("/studentInfo")
    public boolean studentInfo(Student stduent)
    {
        return student_service.StudentInfo(stduent);
    }

    /**
     * 男女比例查询
     * @return
     */
    @RequestMapping("/proportion")
    public HashMap<String,Object> proportion ()
    {
        return student_service.proportion();
    }

    /**
     * 根据名字进行分页查询
     * @param studentName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/likeName")
    public List<Student> likeQuery(String studentName,int pageNo , int pageSize)
    {
        return student_service.likeQuery(studentName,pageNo,pageSize);
    }


    /**
     * 查询数据库中是否存在该邮箱
     * @param Email
     * @return
     */
    @RequestMapping("/checkEmail")
    public String checkEmail(String Email)
    {
        return student_service.checkEmail(Email);
    }
}
