package com.example.newstudentweb.service;


import com.example.newstudentweb.mapper.Dormitory_Mapper;
import com.example.newstudentweb.model.Dormitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return  dormitory_mapper.queryUpdateDormitory(sexType,6);
    }

    public int CountDormitory()
    {
        return dormitory_mapper.CountDormitoryList();
    }


    public String DormitoryNum(int dormitoryId){return dormitory_mapper.DormitoryNum(dormitoryId);}
}
