package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AddressVO;
import com.example.mapper.AddressMapper;
import com.example.mapper.MysqlMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class AddressTest {
    @Autowired
    private AddressMapper mapper;
    @Test
    public void list() { mapper.list(); }
    @Test
    public void read() { mapper.read(7); }
    @Test
    public void delete() {mapper.delete(1);}
    @Test
    public void update() {
    	AddressVO vo=new AddressVO();
    	vo.setId(3);
    	vo.setName("정은경");
    	vo.setAddress("인천 주안구 주안동");
    	vo.setTel("010-7222-4985");
    	mapper.update(vo);}
    @Test
    public void insert() {
    	AddressVO vo=new AddressVO();
    	vo.setName("서혜진");
    	vo.setAddress("인천서구신진말로");
    	vo.setTel("032-555-8888");
    	mapper.insert(vo);
    }
}
