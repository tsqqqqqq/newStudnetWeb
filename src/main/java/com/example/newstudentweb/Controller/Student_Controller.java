package com.example.newstudentweb.Controller;


import com.example.newstudentweb.Uilt.FileUtil;
import com.example.newstudentweb.Uilt.ImportExcelUtil;
import com.example.newstudentweb.service.Student_service;
import com.example.newstudentweb.model.Student;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        public HashMap<String,Object> studentList(int pageNo , int pageSize)
        {
            List<Student> list = student_service.StudentList(pageNo,pageSize);
            HashMap<String,Object> map = new HashMap<String, Object>();
            int count = student_service.QueryCount();
            map.put("count",count);
            map.put("list",list);
            return map;
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

    /**
     * 批量导入 通过导入Excel文件实现
     * @param file 文件名
     * @return
     */
    @RequestMapping("/bulkImport")
    public String bulkImport(@RequestParam("file") MultipartFile file){
        List<Student> list = new ArrayList<Student>();
        String str ="";
        try{
            if(file!=null){
            String fileName = file.getOriginalFilename();
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
                try {
                    // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                    FileUtil.fileupload(file.getBytes(), path, fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File targetfile = new File(path + fileName);
                list = new ImportExcelUtil().getUserList(targetfile);
                if (list.isEmpty()) {
                    System.out.println("模板中无数据");
                    str="模板中无数据";
                } else {
                    //2.保存
                    //this.saveAjxxByStuInfo(list);
                    str = student_service.bulkImport(list);//获取导入成功的记录
                }
            }
        }catch (Exception e){
        }
        return str;
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student formData){
        boolean b = student_service.updateStudent(formData);
        String msg="失败";
        if(b){
            msg="修改成功";
        }
        return msg;
    }

}
