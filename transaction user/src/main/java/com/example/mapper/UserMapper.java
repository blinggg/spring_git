package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.UserVO;

public interface UserMapper {
	public List<UserVO> list();
	public UserVO read(String id);
	public void update(@Param("id") String id, @Param("point") int point); //매개변수 두개 이상일 때 @Param으로 받는다
	
}
