package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.ProductVO;
import com.example.mapper.MysqlMapper;
import com.example.mapper.ProductMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ProductTest {
    @Autowired
    private ProductMapper mapper;

    @Test
    public void insert() { 
    	ProductVO vo=new ProductVO();
    	vo.setPcode("P002");
    	vo.setPname("�ٳ���ű");
    	vo.setPrice(1200);
    	mapper.insert(vo); }
}
