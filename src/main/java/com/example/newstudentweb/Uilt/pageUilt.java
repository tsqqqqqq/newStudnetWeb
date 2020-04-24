package com.example.newstudentweb.Uilt;

import com.example.newstudentweb.mapper.Page_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pageUilt {

        @Autowired
        private Page_Mapper page_mapper;

        @RequestMapping("/StudentPageNo")
        public int StudentPageNo()
        {
             return page_mapper.StudentListNum();
        }
}
