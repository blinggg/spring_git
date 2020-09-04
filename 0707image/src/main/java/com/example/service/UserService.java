package com.example.service;

import com.example.domain.UserVO;

public interface UserService {
	public void insert(UserVO vo);
	public void delete(String id);
	public void update(UserVO vo);
}
