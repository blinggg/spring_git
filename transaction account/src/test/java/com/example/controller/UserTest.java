package com.example.controller;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mapper.AccountMapper;
import com.example.mapper.MessageMapper;
import com.example.mapper.MysqlMapper;
import com.example.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserTest {
    @Autowired
    private UserMapper mapper;
    
    @Autowired
    private MessageMapper mMapper;
    
    @Autowired
    private AccountMapper aMapper;
    
    @Test
    public void aread() {
    	aMapper.read("1001");
    }
    
    @Test
    public void alist() {
    	aMapper.list();
    }
    
    @Test
    public void read1() {
    	mMapper.read(1);
    }
    
    @Test
    public void listSend() {
    	mMapper.listSend("m01");
    }
    @Test
    public void listReceive() {
    	mMapper.listReceive("m01");
    }
    @Test
    public void list() {
    	mapper.list();
    }
    @Test
    public void read() {
    	mapper.read("m01");
    }
    @Test
    public void update() {
    	mapper.update("m01", 5);
    }
    

}
