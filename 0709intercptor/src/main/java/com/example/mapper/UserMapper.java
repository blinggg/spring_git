package com.example.mapper;

import com.example.domain.UserVO;

public interface UserMapper {
	//로그인에 필요한 read(id, pass)값 저장되어있음
	public UserVO read(String id);
	public void insert(UserVO vo);
}
