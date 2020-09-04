package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.Criteria;
import com.example.domain.ProductVO;

public interface ProductMapper {
	
	public void insert(ProductVO vo);
	public List<ProductVO> list(Criteria cri);
	public int totalCount(Criteria cri);
	public ProductVO read(String pcode);
	public void update(ProductVO vo);
	public void delete(String pcode);
	public void addAttach(@Param("image") String image, @Param("pcode") String pcode);
	public List<String> getAttach(String pcode);
	public void delAttach(String pcode);
	
}
