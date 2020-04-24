package com.example.newstudentweb.mapper;

import com.example.newstudentweb.model.Admin;
import com.example.newstudentweb.model.Student;
import com.example.newstudentweb.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;

@Mapper
@Controller
public interface Login_Mapper {

    /**
     * 管理员登陆
     * @param admin
     * @return 管理员对象
     */
    @Select("select * from admin where adminUsers = #{adminUsers} and adminPassWord = #{adminPassWord}")
    public Admin AdminLogin(Admin admin);


    /**
     * 学生修改默认密码之后的登陆方式
     * @param
     * @return
     */
    @Select("select studentIdNum from users where studentIdNum = #{studentIdNum} and studentPassWord = #{studentPassWord}")
    public String UsersLogin(String studentIdNum,String studentPassWord);




    /**
     * 查询学生是否采用默认密码登陆的状态值
     * @param studentIdNum
     * @return
     * 0代表未修改
     * 1代表修改
     */
    @Select("select studentInFo from student where studentIdNum = #{studentIdNum}")
    public int StudentInfo(String studentIdNum);


    /**
     * 检查登陆者身份证号是否在数据库中
     * @param Id
     * @return
     */
    @Select("select * from student where studentIdNum = #{Id}")
    public Student StudentIdNum(String Id);
}
