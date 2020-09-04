package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Resource(name="uploadPath")	//servlet-context���� ������ ���ε� id�̸�
	private String path;

	@Autowired
	ProductService service;
	@Autowired
	ProductMapper mapper;
	
	@RequestMapping("/pro/insert")
	public String insert() {
		return "/pro/insert";
	}
	
	//�̹������� �������� ���
	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName) throws Exception {
		ResponseEntity<byte[]> result = null;
		// display fileName�� �ִ� ���
		if (!fileName.equals("")) {
			File file = new File(path + File.separator + fileName);
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		}
		return result;
	}
	
	@RequestMapping(value="/pro/insert",method=RequestMethod.POST)
	public String insertPost(ProductVO vo, MultipartHttpServletRequest multi) throws Exception {
		MultipartFile file=multi.getFile("file");	//"file"�� form������ �̸�
		//��ǥ���Ͼ��ε�
		if(!file.isEmpty()) {	//���ε��� ������ �������������
			String image=System.currentTimeMillis()+file.getOriginalFilename(); //�и��������� �ߺ�����
			file.transferTo(new File(path + File.separator + image));	//Separator�� ������, �������� �˾Ƽ�
			vo.setImage(image);
		}
		System.out.println(vo.toString());
		//÷�����Ͼ��ε�(������ �ѹ���)
		List<MultipartFile> files=multi.getFiles("files");
		ArrayList<String> images=new ArrayList<String>();
		for(MultipartFile addFile:files) {
			if(!addFile.isEmpty()) {	//���ε��� ������ �������������
				String image=System.currentTimeMillis()+addFile.getOriginalFilename();
				addFile.transferTo(new File(path + File.separator + image));
				images.add(image);
			}
		}
		vo.setImages(images);
		System.out.println(vo.toString());
		service.insert(vo);
		return "redirect:/pro/list";
	}
	
	@RequestMapping("/pro/list")
	public String list(Model model,Criteria cri) {
		PageMaker pm=new PageMaker();
		cri.setPerPageNum(8);
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		model.addAttribute("cri",cri);
		model.addAttribute("pm",pm);
		model.addAttribute("list",mapper.list(cri));
		return "/pro/list";
	}
	
	@RequestMapping("/pro/read")
	public String read(String pcode, Model model) {
		model.addAttribute("list",mapper.getAttach(pcode));
		model.addAttribute("read",mapper.read(pcode));
		return "/pro/read";
	}
	
	@RequestMapping(value="/pro/update",method=RequestMethod.POST)
	public String updatePost(ProductVO vo, MultipartHttpServletRequest multi) throws Exception {
		MultipartFile file=multi.getFile("file");	//"file"�� form������ �̸�
		//���Ͼ��ε�
		if(!file.isEmpty()) {	//���ε��� ������ �������������
			String oldImage=vo.getImage(); //������ �ִ� �̹���
			if(!oldImage.equals("")) {	//�����̹����� ������ ����
				new File(path + File.separator + oldImage).delete();
			}
			String image=System.currentTimeMillis()+file.getOriginalFilename(); //�� �̹���
			file.transferTo(new File(path + File.separator + image));
			vo.setImage(image);
		}
		//÷�� �̹��� ���ε�
		List<MultipartFile> files = multi.getFiles("files");
		ArrayList<String> images = new ArrayList<String>();
		if(!files.get(0).isEmpty()) {
			List<String> oldImages=mapper.getAttach(vo.getPcode());
			for(String oldImage:oldImages) {
				new File(path + File.separator + oldImage).delete();
			}
		}
		for (MultipartFile attFile : files) {
			if (!attFile.isEmpty()) {
				String image = System.currentTimeMillis() + attFile.getOriginalFilename();
				attFile.transferTo(new File(path + File.separator + image));
				images.add(image);
			}
		}
		vo.setImages(images);
		service.update(vo);
		return "redirect:/pro/list";
	}
	
	@RequestMapping(value="/pro/delete",method=RequestMethod.POST)
	public String deletePost(ProductVO vo) throws Exception {
		//���ϻ���
		String oldImage=vo.getImage();
		if(!oldImage.equals("")) {
			new File(path + File.separator + oldImage).delete();
		}
		//÷������(������) ����
		List<String> images=mapper.getAttach(vo.getPcode());
		for(String image:images) {
			new File(path + File.separator + image).delete();
		}
		service.delete(vo.getPcode());
		return "redirect:/pro/list";
	}
	
}
