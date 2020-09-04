package com.example.controller;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mapper.CoursesMapper;
import com.example.mapper.MysqlMapper;
import com.example.mapper.ProfessorsMapper;
import com.example.mapper.StudentsMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class StudentsTest {
    @Autowired
    private StudentsMapper mapper;
    
    @Autowired
    private CoursesMapper cmapper;
    
    @Autowired
    private ProfessorsMapper pmapper;
    
    @Test
    public void list() {
    	pmapper.list();
    	pmapper.slist("221");
    	pmapper.clist("221");
    	
    }
    

}
