package com.example.mapper;

import org.apache.ibatis.annotations.Select;

import com.example.domain.EnrollVO;

public interface EnrollMapper {
	public void insert(EnrollVO vo);
	public void delete(EnrollVO vo);
	public void update(EnrollVO vo);
	public int read(EnrollVO vo);
}
