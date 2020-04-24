package com.example.newstudentweb.mapper;


import com.example.newstudentweb.model.Major;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface Major_Mapper {
    /**
     * 添加专业信息
     * @param major
     * @return
     */
    @Insert("insert into major(majorNum,majorName) value(#{majorNum} ,#{majorName})")
    public boolean MajorAdd(Major major);


    /**
     * 查询所有专业信息列表
     * @return
     */
    @Select("select * from Major")
    public List<Major> MajorList();

    /**
     * 查询专业名
     * @param majorId
     * @return
     */
    @Select("select majorName from major where majorId = #{majorId}")
    public String MajorNum(int majorId);
}
