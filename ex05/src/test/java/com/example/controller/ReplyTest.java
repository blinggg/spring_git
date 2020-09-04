package com.example.controller;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.ReplyVO;
import com.example.mapper.MysqlMapper;
import com.example.mapper.ReplyMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyTest {
    @Autowired
    private ReplyMapper mapper;
//    @Test
//    public void list() { mapper.list(); }
    
    @Test
    public void read() { mapper.read(373); }
    
    @Test
    public void update() { 
    	ReplyVO vo=new ReplyVO();
    	vo.setRno(373);
    	vo.setReply("�ٹٹٹٹ�");
    	vo.setReplyer("�ٹ�");
    	mapper.update(vo); }
    
    @Test
    public void delete() { mapper.delete(1373); }
    
}
