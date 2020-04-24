package com.example.newstudentweb.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface users_Mapper {

        /**
         * 在user表中添加登陆信息
         * @param studentIdNum
         * @param studentPassWord
         * @return
         */
        @Insert("insert into users(studentIdNum,studentPassWord,createDate) value(#{studentIdNum},#{studentPassWord},now())")
        public boolean userInsert(String studentIdNum,String studentPassWord);


        /**
         * 修改user表中的密码
         */
        @Update("update users set studentPassWord = #{studentPassWord} where studentIdNum=#{studentIdNum}")
        public boolean updatePass(String studentIdNum,String studentPassWord);
}
