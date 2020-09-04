package com.example.mapper;

import org.apache.ibatis.annotations.Select;

import com.example.domain.EnrollmentsVO;

public interface EnrollmentsMapper {

    public void insert(EnrollmentsVO vo);
    public int read(EnrollmentsVO vo);
    public void delete(EnrollmentsVO vo); //scode,lcode �ΰ��� ���� �������!
    public void update(EnrollmentsVO vo);
}
