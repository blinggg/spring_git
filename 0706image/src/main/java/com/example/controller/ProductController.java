package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;

@Controller
public class ProductController {
	@Resource(name="uploadPath")
	private String path;
	
	@Autowired
	ProductMapper mapper;
	
	@RequestMapping("/pro/insert")
	public void insert(){
		
	}
	
	@RequestMapping(value="/pro/insert", method=RequestMethod.POST)
	public String insertPost(ProductVO vo,MultipartHttpServletRequest multi) throws Exception{
		MultipartFile file=multi.getFile("file");
		//���Ͼ��ε�
		if(!file.isEmpty()) {
			String image=System.currentTimeMillis()+file.getOriginalFilename();
			file.transferTo(new File(path+File.separator+image));
			vo.setImage(image);
			
		}
		System.out.println(vo.toString());
		mapper.insert(vo);
		return "redirect:list";
	}
	
	@RequestMapping("/pro/list")
	public void list(Model model,Criteria cri){
		System.out.println(cri.toString());
		cri.setPerPageNum(8);
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		
		model.addAttribute("cri", cri);
		model.addAttribute("pm",pm);
		model.addAttribute("list",mapper.list(cri));
	}
	
	//�̹������� �������� ���
	@RequestMapping("/display")
	@ResponseBody
	
	public ResponseEntity<byte[]> display(String fileName)throws Exception{
	 ResponseEntity<byte[]> result=null;
	 //display fileName�� �ִ� ���
	 if(!fileName.equals("")) {
	 File file=new File(path + File.separator + fileName);
	 HttpHeaders header=new HttpHeaders();
	 header.add("Content-Type", Files.probeContentType(file.toPath()));
	 result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
	 }
	 return result;
	}

	@RequestMapping("/pro/read")
	public void read(String pcode,Model model){
		model.addAttribute("vo",mapper.read(pcode));
	}
	
	@RequestMapping(value="/pro/update", method=RequestMethod.POST)
	public String updatePost(ProductVO vo,MultipartHttpServletRequest multi) throws Exception{
		MultipartFile file=multi.getFile("file");
		//���Ͼ��ε�
		if(!file.isEmpty()) {
			//�����̹����� ���� �� �����ϱ�
			String oldImage=vo.getImage();
			if(!oldImage.equals("")) {
				new File(path + File.separator+oldImage).delete();
			}
			
			//���ο� �̹��� ����ϱ�
			String image=System.currentTimeMillis()+file.getOriginalFilename();
			file.transferTo(new File(path+File.separator+image));
			vo.setImage(image);
			
		}
		System.out.println(vo.toString());
		mapper.update(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value="/pro/delete", method=RequestMethod.POST)
	public String deletePost(ProductVO vo) throws Exception{
		//���ϻ���
		String oldImage=vo.getImage();
		if(!oldImage.equals("")) {
			new File(path + File.separator+oldImage).delete();
		}
		//System.out.println(vo.toString());
		mapper.delete(vo.getPcode());
		return "redirect:list";
	}
	
}
