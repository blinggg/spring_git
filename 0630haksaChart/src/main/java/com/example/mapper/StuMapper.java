package com.example.mapper;

import java.util.List;

import com.example.domain.Criteria;
import com.example.domain.EnrollVO;
import com.example.domain.StuVO;

public interface StuMapper {
    public List<StuVO> list(Criteria cri);
    public StuVO read(String scode);
    public void update(StuVO vo);
    public void delete(String scode);
    public int totalCount();
    public int enrollCount(String scode);
    public List<EnrollVO> listEnroll(String scode);
}
