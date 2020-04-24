package com.example.newstudentweb.mapper;


import com.example.newstudentweb.model.Class;
import com.example.newstudentweb.model.Major;
import com.example.newstudentweb.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
@Controller
public interface Class_Mapper {


    /**
     * 查询所有的专业列表
     * @return
     */
    @Select("select * from major")
    public List<Major> MajorList();



    /**
     * 查询某一专业下的所有班级
     * @param majorId
     * @return
     */
    @Select("select * from Class c inner join major m on c.majorId = m.majorId where c.majorId = #{majorId}")
    public List<Class> ClassList(int majorId);


    /**
     * 查询某一班级里得所有学生信息
     * @param classId
     * @return
     */
    @Select("select * from student where classId = #{classId}")
    public List<Student> classShow(int classId);


    /**
     * 添加班级信息
     * @param
     * @return
     */
    @Insert("insert into class(majorId,classNum) value(#{majorId},#{classNum})")
    public boolean classAdd(int majorId , String classNum);


    /**
     * 获取当前专业中的最后一个班级的编号 方便向下添加
     * @param majorId
     * @return
     */
    @Select("select classNum from class where majorId = #{majorId} order by  classNum desc limit 0,1")
    public String queryClassNum(int majorId);

    /**
     * 根据班级编号 查询班级Id
     * @param classNum
     * @return
     */
    @Select ("select classId from class where classNum = #{classNum}")
    public int queryClassId(String classNum);


    /**
     * 查询某一学生被录取专业下的所有班级
     * @param studentId
     * @return
     */
    @Select("select c.classId from student s inner join class c on c.majorId  = s.majorId where s.studentId = #{studentId} ")
    public List<Integer> queryStudentMajorClass(int studentId);

    /**
     * 根据班级ID查询班级名称
     * @param classId
     * @return
     */
    @Select("select classNum from Class where classId = #{classId}")
    public String ClassNum(int classId);

}
