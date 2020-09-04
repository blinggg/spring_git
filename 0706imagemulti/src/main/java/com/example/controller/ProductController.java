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
	@Resource(name="uploadPath")	//servlet-context에서 지정한 업로드 id이름
	private String path;

	@Autowired
	ProductService service;
	@Autowired
	ProductMapper mapper;
	
	@RequestMapping("/pro/insert")
	public String insert() {
		return "/pro/insert";
	}
	
	//이미지파일 브라우저에 출력
	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName) throws Exception {
		ResponseEntity<byte[]> result = null;
		// display fileName이 있는 경우
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
		MultipartFile file=multi.getFile("file");	//"file"은 form에서의 이름
		//대표파일업로드
		if(!file.isEmpty()) {	//업로드할 파일이 비어있지않으면
			String image=System.currentTimeMillis()+file.getOriginalFilename(); //밀리세컨으로 중복방지
			file.transferTo(new File(path + File.separator + image));	//Separator는 슬래시, 역슬래시 알아서
			vo.setImage(image);
		}
		System.out.println(vo.toString());
		//첨부파일업로드(여러개 한번에)
		List<MultipartFile> files=multi.getFiles("files");
		ArrayList<String> images=new ArrayList<String>();
		for(MultipartFile addFile:files) {
			if(!addFile.isEmpty()) {	//업로드할 파일이 비어있지않으면
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
		MultipartFile file=multi.getFile("file");	//"file"은 form에서의 이름
		//파일업로드
		if(!file.isEmpty()) {	//업로드할 파일이 비어있지않으면
			String oldImage=vo.getImage(); //기존에 있던 이미지
			if(!oldImage.equals("")) {	//기존이미지가 있으면 삭제
				new File(path + File.separator + oldImage).delete();
			}
			String image=System.currentTimeMillis()+file.getOriginalFilename(); //새 이미지
			file.transferTo(new File(path + File.separator + image));
			vo.setImage(image);
		}
		//첨부 이미지 업로드
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
		//파일삭제
		String oldImage=vo.getImage();
		if(!oldImage.equals("")) {
			new File(path + File.separator + oldImage).delete();
		}
		//첨부파일(여러개) 삭제
		List<String> images=mapper.getAttach(vo.getPcode());
		for(String image:images) {
			new File(path + File.separator + image).delete();
		}
		service.delete(vo.getPcode());
		return "redirect:/pro/list";
	}
	
}
