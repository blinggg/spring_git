package com.example.controller;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.UserVO;
import com.example.mapper.MysqlMapper;
import com.example.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //∏’¿˙ SpringJUnit4ClassRunner.class import«—¥Ÿ.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserTest {
    @Autowired
    private UserMapper mapper;
    @Test
    public void list() { mapper.list(); }
    @Test
    public void delete() { mapper.delete("ek"); }
    @Test
    public void read() { mapper.read("ekkkk"); }
    @Test
    public void update() { 
    	UserVO vo=new UserVO();
    	vo.setId("jeg4985");
    	vo.setName("¿ÃªÛ»Ò");
    	vo.setPass("pass1");
    	mapper.update(vo); }
    @Test
    public void insert() { 
    	UserVO vo=new UserVO();
    	vo.setId("ekkkk");
    	vo.setName("¡§¿∫∞¡");
    	vo.setPass("pass");
    	mapper.insert(vo); }
    
    
}
