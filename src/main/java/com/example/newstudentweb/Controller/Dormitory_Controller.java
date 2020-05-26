package com.example.newstudentweb.Controller;


import com.example.newstudentweb.model.Dormitory;
import com.example.newstudentweb.service.Dormitory_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class Dormitory_Controller {

        @Autowired
        private Dormitory_Service dormitory_service;

    @RequestMapping("/DormitoryList")
    public HashMap<String,Object> DormitoryList(int pageNo, int pageSize)
    {
        HashMap<String,Object> map = new HashMap<String, Object>();
        List<Dormitory> list = dormitory_service.DormitoryList(pageNo,pageSize);
        int count=dormitory_service.CountDormitory();
        map.put("count",count);
        map.put("list",list);
        return map;
    }

    @RequestMapping("/NotClassDormitoryList")
    public List<Dormitory> NotClassDormitoryList(int pageNo, int pageSize)
    {
        return dormitory_service.NotClassDormitoryList(pageNo,pageSize);
    }

    @RequestMapping("/queryUpdateDormitoryList")
    public List<Dormitory> queryUpdateDormitoryList(String studentSex){
        return dormitory_service.queryUpdateDormitoryList(studentSex);
    }

    @RequestMapping("/CountDormitory")
    public int CountDormitory()
    {
        return dormitory_service.CountDormitory();
    }

    @RequestMapping("/DormitoryNum")
    public String DormitoryNum(int dormitoryId){return dormitory_service.DormitoryNum(dormitoryId);}
}
