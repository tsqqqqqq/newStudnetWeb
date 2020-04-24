package com.example.newstudentweb.service;

import com.example.newstudentweb.mapper.Class_Mapper;
import com.example.newstudentweb.model.Class;
import com.example.newstudentweb.model.Major;
import com.example.newstudentweb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Class_Service {


    @Autowired
    private Class_Mapper class_mapper;


    @Autowired
    private Student_service student_service;

    /**
     * 查询出专业列表
     * @return
     */
    public List<Major> MajorList ()
    {
            return  class_mapper.MajorList();
    }


    /**
     * 查询出某一专业下的所有班级列表
     * @param majorId
     * @return
     */
    public List<Class> ClassList(int majorId) { return class_mapper.ClassList(majorId);}


    /**
     * 查询某一班级里的所有学生列表
     * @param classId
     * @return
     */
    public List<Student>  classShow(int classId) { return class_mapper.classShow(classId); }

    /**
     * 添加班级 并分配班级的学生数量
     * @param majorId
     * @return
     */
    public boolean classAdd(int majorId) {
        boolean b = false;
        int NotClass = student_service.studentNotClass(majorId);


        int classNumber = NotClass % 38;
        if (classNumber == 0) {
            classNumber = NotClass / 38;
        } else {
            classNumber = (NotClass / 38) + 1;
        }
        for (int i = 0; i < classNumber; i++)
        {
            List<Integer> NotClassStudentId = student_service.NotClassStudentId(majorId,i*38);

            String classNum = class_mapper.queryClassNum(majorId);
            int Num = Integer.parseInt(classNum)+1;
             b  = class_mapper.classAdd(majorId,String.valueOf(Num));
             System.out.println("b1==========>"+b);
            if(b)
            {
                int classId  = class_mapper.queryClassId(String.valueOf(Num));
                System.out.println(classId);
                for(int j = 0 ;j<NotClassStudentId.size();j++)
                {
                    b = student_service.AssignStudentToClass(classId,NotClassStudentId.get(j));
                }
                System.out.println("b2==========>"+b);
            }

        }


        return b;
    }

    /**
     * 根据班级Id查询班级名
     * @param classId
     * @return
     */
    public String classNum(int classId){return class_mapper.ClassNum(classId);}
}
