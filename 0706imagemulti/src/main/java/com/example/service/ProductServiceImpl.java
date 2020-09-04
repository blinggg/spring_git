package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductMapper mapper;
	
	@Transactional
	@Override
	public void insert(ProductVO vo) {
		mapper.insert(vo);
		//Ã·ºÎÆÄÀÏ insert
		ArrayList<String> images=vo.getImages();
		for(String image:images) {
			mapper.addAttach(image, vo.getPcode());
		}
	}

	@Transactional
	@Override
	public void delete(String pcode) {
		mapper.delAttach(pcode);
		mapper.delete(pcode);
	}

	@Transactional
	@Override
	public void update(ProductVO vo) {
		mapper.update(vo);
		ArrayList<String> images = vo.getImages();
		if (images.size() > 0) {
			mapper.delAttach(vo.getPcode());
			for (String image : images) {
				mapper.addAttach(image, vo.getPcode());
			}
		}
	}
	
}
