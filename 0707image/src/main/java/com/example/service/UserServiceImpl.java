package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.UserVO;
import com.example.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper mapper;
	
	@Transactional
	@Override
	public void insert(UserVO vo) {
		mapper.insert(vo);
		List<String> images=vo.getImages();
		for(String image:images) {
			mapper.addAttach(image, vo.getId());
		}	
	}
	
	@Transactional
	@Override
	public void delete(String id) {
		mapper.delAttach(id);
		mapper.delete(id);
		
	}
	
	@Transactional
	@Override
	public void update(UserVO vo) {
		mapper.update(vo);
		mapper.delAttach(vo.getId());
		List<String> images=vo.getImages();
		for(String image:images) {
			mapper.addAttach(image, vo.getId());
		}	
	}

}
