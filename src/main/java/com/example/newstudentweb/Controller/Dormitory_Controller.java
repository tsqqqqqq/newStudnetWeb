package com.example.newstudentweb.Controller;


import com.example.newstudentweb.model.Dormitory;
import com.example.newstudentweb.service.Dormitory_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Dormitory_Controller {

        @Autowired
        private Dormitory_Service dormitory_service;

    @RequestMapping("/DormitoryList")
    public List<Dormitory> DormitoryList(int pageNo, int pageSize)
    {
        return dormitory_service.DormitoryList(pageNo,pageSize);
    }

    @RequestMapping("/NotClassDormitoryList")
    public List<Dormitory> NotClassDormitoryList()
    {
        return dormitory_service.NotClassDormitoryList();
    }


    @RequestMapping("/CountDormitory")
    public int CountDormitory()
    {
        return dormitory_service.CountDormitory();
    }

    @RequestMapping("/DormitoryNum")
    public String DormitoryNum(int dormitoryId){return dormitory_service.DormitoryNum(dormitoryId);}
}
