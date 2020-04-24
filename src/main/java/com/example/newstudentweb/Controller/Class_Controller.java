package com.example.newstudentweb.Controller;

import com.example.newstudentweb.service.Class_Service;
import com.example.newstudentweb.model.Class;
import com.example.newstudentweb.model.Major;
import com.example.newstudentweb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Class_Controller {

        @Autowired
        private Class_Service class_service;

        @RequestMapping("/MajorList")
        public List<Major> MajorList() { return class_service.MajorList(); }

        @RequestMapping("/classList")
        public List<Class> classList(int majorId) { return class_service.ClassList(majorId); }

        @RequestMapping("/classShow")
        public List<Student>  classShow(int classId) { return class_service.classShow(classId); }

        @RequestMapping("/classAdd")
        public boolean classAdd(int MajorId) { return class_service.classAdd(MajorId);}

        @RequestMapping("/classNum")
        public String classNum(int classId){return class_service.classNum(classId);}


}
