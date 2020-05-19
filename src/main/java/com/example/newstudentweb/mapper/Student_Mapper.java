package com.example.newstudentweb.mapper;


import com.example.newstudentweb.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
@Controller
public interface Student_Mapper {

    /**
     * 查询所有已录入的学生列表
     * @return
     */
    @Select("select * from student limit #{pageNo},#{pageSize}")
    public List<Student> StudentList(int pageNo,int pageSize);


    /**
     * 录入学生信息
     * @param student
     * @return
     */
    @Insert("insert into student(studentName,studentAge,studentSex,studentIdNum,studentType,studentExamNum,studentPhone,studentAddr," +
            "studentEmail,studentMoney,studentInFo,majorId) value(#{studentName},#{studentAge},#{studentSex},#{studentIdNum},#{studentType}," +
            "#{studentExamNum},#{studentPhone},#{studentAddr},#{studentEmail},#{studentMoney},0,#{majorId})")
    public boolean studentAdd(Student student);


    /**
     * 根据学生ID查询学生信息
     * @param studentId
     * @return
     */
    @Select("select * from student where studentId = #{studentId}")
    public Student showStudent(int studentId);

    /**
     * 查询当前专业录取人数
     */
    @Select("select count(studentId) from student where majorId = #{majorId}")
    public  int StudentNumber(int majorId);


    /**
     * 查询未被分配的学生数量
     * @param majorId
     * @return
     */
    @Select("select count(studentId) from student where majorId = #{majorId} and classId is Null ")
    public int StudentNotClass(int majorId);


    /**
     * 查询未被分配的学生Id
     * @param majorId
     * @return
     */
    @Select("select studentId from student where majorId = #{majorId} and classId is null limit #{nowNum} ,38")
    public List<Integer> queryNotClassStudentId(int majorId,int nowNum);


    /**
     * 分配学生到班级
     * @param studentId
     * @return
     */
    @Update("update student set classId = #{classId} where studentId = #{studentId}")
    public boolean AssignStudentToClass(int classId,int studentId);

    /***
     * 分配学生到宿舍
     * @param dormitoryId
     * @param studentId
     * @return
     */
    @Update("update student set dormitoryId = #{dormitoryId} where studentId = #{studentId}")
    public boolean AssignStudentToDormitory(int dormitoryId,int studentId);

    /**
     * 校验学生准考证号
     * @param examNum
     * @param IdNum
     * @return
     */
    @Select("select * from student where studentExamNum =#{examNum} and studentIdNum = #{IdNum}")
    public Student studentExamNum(String examNum , String IdNum);


    /**
     * 应届生学生激活
     * @param
     * @return
     */
    @Update("update student set studentInfo=1 , studentMoney = 15000 , studentActivaTime = now() ,studentEmail = #{studentEmail} ,studentPhone = #{studentPhone} " +
            "where studentId = #{studentId}")
    public boolean studentInfo(Student student);

    /**
     * 专升本学生激活
     * @param
     */
    @Update("update student set studentInfo=1 , studentMoney = 8500 , studentActivaTime = now() ,studentEmail = #{studentEmail} ,studentPhone = #{studentPhone} " +
            "where studentId = #{studentId}")
    public boolean studentInfo2(Student student);

    /**
     * 查询女生总人数
     * @return
     */
    @Select("select count(studentId) from student where studentSex = '女' ")
    public int StudentGirl();


    /**
     * 查询男生总人数
     * @return
     */
    @Select("select count(studentId) from student where studentSex = '男' ")
    public int StudentBoy();

    /**
     * 根据名字模糊查询个人信息
     * @param studentName
     * @return
     */
    @Select("select * from student where studentName like '%${studentName}%' limit #{pageNo} , #{pageSize}")
    public List<Student> LikeQuery(String studentName,int pageNo,int pageSize);


    /**
     * 查询数据库中是否存在改邮箱
     */
    @Select("Select StudentIdNum from student where studentEmail = #{Email}")
    public String checkEmail(String Email);
}
