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

@RunWith(SpringJUnit4ClassRunner.class)  //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserTest {

    @Autowired
    AccountMapper amapper;
    
    @Test
    public void list() { 
    	amapper.list(); }
    
    /*@Test
    public void read() { 
    	mapper.read("amorpatis2"); }
    
    @Test
    public void update() { 
    	mapper.update("amorpatis2",5); }
    
    @Test
    public void send() { 
    	mmapper.listsend("jeg4985"); }
    
    @Test
    public void receive() { 
    	mmapper.listreceive("amorpatis2"); }*/
    
 
    
    
}
