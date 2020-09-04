package com.example.controller;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mapper.MysqlMapper;
import com.example.mapper.SumMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlTest {
    @Autowired
    private MysqlMapper mapper;
    @Autowired
    private SumMapper smapper;
    @Test
    public void getTime() { mapper.getTime(); }
    @Test
    public void getTime2() { mapper.getTime2(); }
    @Test
    public void sum1() { smapper.sum1(); }
    @Test
    public void sum2() { smapper.sum2(); }
    @Test
    public void sum6() { smapper.sum6(); }
}
