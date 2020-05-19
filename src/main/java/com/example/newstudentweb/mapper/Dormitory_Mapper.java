package com.example.newstudentweb.mapper;


import com.example.newstudentweb.model.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface Dormitory_Mapper {

    /**
     * 分页查询已分配到班级的宿舍列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Select("select * from dormitory where classId is  null and dormitoryInfo = 0 limit #{pageNo},#{pageSize}")
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
    @Select("select * from dormitory where dormitoryType = #{sexType} and max<#{Max} limit 0,1")
    public Dormitory queryDormitory(int sexType,int Max);

    @Update("update dormitory set Max =#{max} where dormitoryId = #{dormitoryId}")
    public boolean DormitoryMax(int dormitoryId,int max);
}
