package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.UserVO;

public interface UserMapper {

	public List<UserVO> list();
	public UserVO read(String id);
	public void update(@Param("id") String id, @Param("point") int point);
	
}
