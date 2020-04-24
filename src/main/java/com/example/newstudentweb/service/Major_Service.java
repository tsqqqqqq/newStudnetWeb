package com.example.newstudentweb.service;


import com.example.newstudentweb.mapper.Major_Mapper;
import com.example.newstudentweb.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Major_Service {

    @Autowired
    private Major_Mapper major_mapper;


    /**
     * 查询专业信息列表
     * @return
     */
    public List<Major> MajorList()
    {
        return major_mapper.MajorList();
    }

    /**
     * 查询专业名称
     * @param majorId
     * @return
     */
    public String MajorName(int majorId)
    {
        return major_mapper.MajorNum(majorId);
    }
}
