package com.example.newstudentweb.mapper;


import com.example.newstudentweb.model.Dormitory;
import com.example.newstudentweb.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface Dormitory_Mapper {

    /**
     * 分页查询人数未满的宿舍列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Select("select * from dormitory  limit #{pageNo},#{pageSize}")
    public List<Dormitory> DormitoryList(int pageNo, int pageSize);

    /**
     * 分页查询未分配到班级的宿舍列表
     * * @param p
     * @param
     * @return
     */
    @Select("select * from dormitory where classId is  null and dormitoryInfo = 0 ")
    public List<Dormitory> NotClassDormitoryList(int pageNo, int pageSize);

    @Select("select count(dormitoryId) from dormitory")
    public int CountDormitoryList();

    @Select("select dormitoryNum from dormitory where dormitoryId = #{dormitoryId}")
    public String DormitoryNum(int dormitoryId);

    /**
     * 查询当前学生的性别一致的宿舍
     * @return
     */
    @Select("select * from dormitory where dormitoryType = #{sexType} and dormitorySum<max limit 0,1")
    public Dormitory queryDormitory(int sexType);

    /**
     * 查询性别以及宿舍容量都在范围内的宿舍列表
     * @param sexType
     * @return
     */
    @Select("select * from dormitory where dormitoryType = #{sexType} and dormitorySum<max ")
    public List<Dormitory> queryUpdateDormitory(int sexType);

    /**
     * 修改宿舍当前容量
     * @param dormitoryId
     * @param max
     * @return
     */
    @Update("update dormitory set Max =#{max} where dormitoryId = #{dormitoryId}")
    public boolean DormitoryMax(int dormitoryId,int max);


    /**
     * 修改宿舍人数
     * @param dormitoryId
     * @param dormitorySum
     * @return
     */
    @Update("update dormitory set dormitorySum =#{dormitorySum} where dormitoryId = #{dormitoryId}")
    public boolean DormitorydormitorySum(int dormitoryId,int dormitorySum);
    /**
     * 修改宿舍状态
     * @param dormitoryId
     * @return
     */
    @Update("update dormitory set dormitoryInFo =1 where dormitoryId = #{dormitoryId}")
    public boolean UpdatedormitoryInFo(int dormitoryId);

    /**
     * 查询学生原宿舍信息
     * @param studentId
     * @return
     */
    @Select("select s.dormitoryId as oldDormitoryId ,d.dormitorySum as oldDormitorySum from student s inner join dormitory d  on d.dormitoryId=s.dormitoryId  where studentId = #{studentId}")
    public HashMap<String,Object> oldStudentDormitoryId(int studentId);


    /**
     * 查询新宿舍的容纳人数
     * @param DormitoryId
     * @return
     */
    @Select("select dormitorySum  from  dormitory  where dormitoryId = #{DormitoryId}")
    public int newDormitoryIdMax(int DormitoryId);


    /**
     * 查看当前新宿舍是否已经满人
     * @param newDormitoryId
     * @return
     */
    @Select("select dormitoryInFo from dormitory where dormitoryId = #{newDormitoryId}")
    public int dormitoryInfo(int newDormitoryId);

    @Select("select max from dormitory where dormitoryId = #{dormitoryId}")
    public int queryMax(int dormitoryId);


    @Select("select * from student where dormitoryId = #{dormitoryId}")
    public List<Student> queryDomitoryStudent(int dormitoryId);

    @Select("select count(studentId) from student where dormitoryId = #{dormitoryId}")
    public int queryDomitoryStudentCount(int dormitoryId);
}
