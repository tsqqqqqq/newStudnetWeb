package com.example.newstudentweb.service;


import com.example.newstudentweb.mapper.Dormitory_Mapper;
import com.example.newstudentweb.model.Dormitory;
import com.example.newstudentweb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Dormitory_Service {


    @Autowired
    private Dormitory_Mapper dormitory_mapper;



    public List<Dormitory> DormitoryList(int pageNo,int pageSize)
    {
        pageNo=(pageNo-1)*pageSize;
        return dormitory_mapper.DormitoryList(pageNo,pageSize);
    }



    public List<Dormitory> NotClassDormitoryList(int pageNo, int pageSize)
    {
        return dormitory_mapper.NotClassDormitoryList(pageNo,  pageSize);
    }


    public List<Dormitory> queryUpdateDormitoryList(String studentSex )
    {
        int sexType=-1;
        if(studentSex.equals("男")||studentSex=="男"){
            sexType = 0;
        }else{
             sexType=1;
        }
        return  dormitory_mapper.queryUpdateDormitory(sexType);
    }

    public int CountDormitory()
    {
        return dormitory_mapper.CountDormitoryList();
    }


    public String DormitoryNum(int dormitoryId){return dormitory_mapper.DormitoryNum(dormitoryId);}

    public HashMap<String,Object> queryDormitoryStudent(int dormitoryId){
        HashMap<String,Object> map = new HashMap<String, Object>();
        List<Student> list = new ArrayList<Student>();
        list=dormitory_mapper.queryDomitoryStudent(dormitoryId);
        int count=dormitory_mapper.queryDomitoryStudentCount(dormitoryId);
        map.put("list",list);
        map.put("count",count);
        return map;
    }
}
