package com.example.service;

import com.example.domain.ProductVO;

public interface ProductService {

	public void insert(ProductVO vo);
	public void delete(String pcode);
	public void update(ProductVO vo);
}
