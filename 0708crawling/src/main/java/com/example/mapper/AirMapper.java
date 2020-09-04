package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.AirVO;

public interface AirMapper {
	public void insert(AirVO vo);
	public List<AirVO> list();
	public AirVO read(String title);
	
}
