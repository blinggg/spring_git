package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.ProVO;

public interface ProMapper {
	public List<ProVO> list();
}
