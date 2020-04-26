package com.example.newstudentweb.Controller;


import com.example.newstudentweb.model.Major;
import com.example.newstudentweb.service.Class_Service;
import com.example.newstudentweb.service.Major_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Major_Controller {


        @Autowired
        private Major_Service major_service;


        @Autowired
        private Class_Service class_service;


        /**
         * 查询所有专业信息
         * @return
         */
        @RequestMapping("/majorList")
        public List<Major> MajorList()
        {
                return major_service.MajorList();
        }


        /**
         * 查询专业名称
         * @param majorId
         * @return
         */
        @RequestMapping("/majorName")
        public String MajorName(int majorId)
        {
                return major_service.MajorName(majorId);
        }




}
