package com.example.mapper;

import com.example.domain.UserVO;

public interface UserMapper {
	//�α��ο� �ʿ��� read(id, pass)�� ����Ǿ�����
	public UserVO read(String id);
	public void insert(UserVO vo);
}
