package com.example.newstudentweb.service;

import com.example.newstudentweb.entity.ID_entity;
import com.example.newstudentweb.mapper.Class_Mapper;
import com.example.newstudentweb.mapper.Student_Mapper;
import com.example.newstudentweb.Uilt.certificateUtilt;
import com.example.newstudentweb.model.Class;
import com.example.newstudentweb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED , isolation =  Isolation.DEFAULT)
public class Student_service {

    @Autowired
    private Student_Mapper student_mapper;

    @Autowired
    private certificateUtilt certificateUtilt;

    @Autowired
    private Class_Mapper class_mapper;

    @Autowired
    private ID_entity id_entity;
    /**
     * 返回学生列表的集合
     * @return
     */
    public List<Student> StudentList(int pageNo,int pageSize)
    {

        return  student_mapper.StudentList(pageNo-1,pageSize);
    }

    /**
     * 学生录入
     * @param student
     * @return
     */

    public boolean studentAdd(Student student)
    {
        String studentIdNum = student.getStudentIdNum();

        //调用工具类 获取 身份证的 性别 年龄 和出生年月日信息
        HashMap<String , Object>  map = certificateUtilt.getBirAgeSex(studentIdNum);
        student.setStudentSex((String) map.get("sexCode"));
        String ages = (String) map.get("age");
        int age = Integer.parseInt(ages);
        student.setStudentAge(age);

        //调用加密算法 对出生年月日进行加密 替换未加密的身份证信息
        String birth = (String) map.get("birthday");
        String word = id_entity.keyEntity(birth);
        System.err.println("b-->"+birth);
        System.err.println("word-->"+word);
        System.err.println(studentIdNum.replaceAll(birth,word));
        student.setStudentIdNum(studentIdNum.replaceAll(birth,word));

        return student_mapper.studentAdd(student) ? true: false;
    }


    /**
     * 查询某一个学生的信息
     * @param studentId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS , isolation =  Isolation.DEFAULT , readOnly = true)
    public Student showStudent(int studentId)
    {
        Student student = student_mapper.showStudent(studentId);
//        String IdNum =student.getStudentIdNum();
//        String birth = IdNum.substring(6,14);
//        String Id = IdNum.replaceAll(birth,id_entity.keyJM(birth));
        //student.setStudentIdNum(Id);

        return student;
    }

    /**
     *查询某一个专业录取的学生数量
     */
    public int studentNumber(int majorId)
    {
        return student_mapper.StudentNumber(majorId);
    }


    /**
     * 查询未被录取的学生数量
     * @param majorId
     * @return
     */
    public int studentNotClass(int majorId){return student_mapper.StudentNotClass(majorId);}


    /**
     *查询未被录取的学生Id
     * @param majorId
     * @return
     */
    public List<Integer> NotClassStudentId(int majorId,int nowNum){ return student_mapper.queryNotClassStudentId(majorId,nowNum); }


    /**
     * 分配学生到班级
     * @param classId
     * @param studentId
     * @return
     */
    public boolean AssignStudentToClass(int classId , int studentId){return student_mapper.AssignStudentToClass(classId,studentId);}

    /**
     * 校验学生准考证号
     * @param examNum
     * @param IdNum
     * @return
     */
    public boolean StudentExamNum(String examNum , String IdNum)
    {
        HashMap<String , Object> map = certificateUtilt.getBirAgeSex(IdNum);
        String birth = id_entity.birthString((String) map.get("birthday"));
        String word = id_entity.keyEntity(birth);
        String id = IdNum.replaceAll(birth,word);

        if(student_mapper.studentExamNum(examNum,id)!=null)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 学生激活
     * @param student
     * @return
     */
    public boolean StudentInfo(Student student)
    {

        boolean b =false;
        if(student.getStudentType()==1)
        {
            b=true;
            student_mapper.studentInfo(student);
        }
        else if(student.getStudentType()==0)
        {
            b=false;
            student_mapper.studentInfo2(student);
        }

        int studentId = student.getStudentId();
        StudentClass(studentId);
       return  b;
    }


    /**
     * 查询男女比例
     * @return
     */
    public HashMap<String,Object> proportion()
    {
        HashMap<String,Object> map  =new HashMap<String, Object>();
        map.put("女",student_mapper.StudentGirl());
        map.put("男",student_mapper.StudentBoy());
        return map;
    }

    /**
     * 根据学生姓名进行分页查询
     * @param studentName
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<Student> likeQuery(String studentName,int pageNo , int pageSize)
    {
        pageNo = (pageNo-1)*pageSize;
        return student_mapper.LikeQuery(studentName,pageNo,pageSize);
    }

    /**
     * 查询数据库中是否存在该邮箱
     * @param Email
     * @return
     */
    public String checkEmail(String Email){
        return student_mapper.checkEmail(Email);
    }

    /**
     * 学生激活时对其分配班级
     * @param studentId
     * @return
     */
    public void StudentClass(int studentId)
    {

        List<Integer> classId = class_mapper.queryStudentMajorClass(studentId);

        for(int i =0;i<classId.size();i++)
        {
            if(class_mapper.classShow(classId.get(i)).size()<38)
            {
                student_mapper.AssignStudentToClass(classId.get(i),studentId);
                break;
            }
        }

    }
}
