package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //∏’¿˙ SpringJUnit4ClassRunner.class import«—¥Ÿ.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ProductTest {
    @Autowired
    private ProductMapper mapper;
    @Test
    public void insert() {
    	ProductVO vo=new ProductVO();
    	vo.setPcode("P101");
    	vo.setPname("≈¡ºˆ¿∞");
    	vo.setPrice(16000);
    	mapper.insert(vo);
    }
    /*
    @Test
    public void list() {
    	mapper.list();
    }
    */
}
