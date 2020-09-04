package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.SEnrollVO;
import com.example.domain.StudentsVO;

public interface StudentsMapper {
    public List<StudentsVO> list();
    public List<SEnrollVO> elist(String scode);
    public void insert(StudentsVO vo);
    public void delete(String scode);
}
