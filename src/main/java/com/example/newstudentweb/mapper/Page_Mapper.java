package com.example.newstudentweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 此接口用于计算查询列表的总数据量
 */
@Mapper
@Component
public interface Page_Mapper {

        /**
         * 查询学生列表的总数量
         * @return
         */
        @Select("select count(studentId) from student" )
        public int StudentListNum();
}
