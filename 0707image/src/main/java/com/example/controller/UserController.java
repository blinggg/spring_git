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

import com.example.domain.UserVO;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

@Controller
public class UserController {
	@Resource(name="userPath")
	private String path;
	
	@Autowired
	UserMapper mapper;
	
	@Autowired
	UserService service;
	
	@RequestMapping("/user/insert")
	public void insert(UserVO vo) {
		
	}
	
	@RequestMapping("/user/list")
	public void list(Model model) {
		model.addAttribute("list",mapper.list());
	}
	
	@RequestMapping("/user/read")
	public void read(Model model,String id) {
		model.addAttribute("list",mapper.getAttach(id));
		model.addAttribute("vo",mapper.read(id));
	}
	
	@RequestMapping(value="/user/insert",method=RequestMethod.POST)
	public String insertPost(UserVO vo,MultipartHttpServletRequest multi) throws Exception{
		//대표이미지 업로드
		MultipartFile file=multi.getFile("file");
		if(!file.isEmpty()) {
			String image=System.currentTimeMillis()+file.getOriginalFilename();
			file.transferTo(new File(path+File.separator+image));
			vo.setImage(image);
		}
		
		//추가이미지 업로드
		List<MultipartFile> files=multi.getFiles("files");
		//이미지를 저장할 배열 생성
		List<String> images=new ArrayList<String>();
		for(MultipartFile attfile:files) {
			if(!attfile.isEmpty()) {
				String image=System.currentTimeMillis()+attfile.getOriginalFilename();
				attfile.transferTo(new File(path+File.separator+image));
				images.add(image);
			}
		}
		vo.setImages(images);
		service.insert(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value="/user/update",method=RequestMethod.POST)
	public String updatePost(UserVO vo,MultipartHttpServletRequest multi)throws Exception {
		MultipartFile file=multi.getFile("file");	//"file"은 form에서의 이름
				//파일업로드
				if(!file.isEmpty()) {	//업로드할 파일이 비어있지않으면
					//기존이미지가 있으면 삭제
					if(!vo.getImage().equals("")) {	
						new File(path + File.separator + vo.getImage()).delete();
					}
					String image=System.currentTimeMillis()+file.getOriginalFilename(); //새 이미지
					file.transferTo(new File(path + File.separator + image));
					vo.setImage(image);
				}
				
				//추가이미지 업로드
				List<MultipartFile> files=multi.getFiles("files");
				
				//옛 첨부이미지 삭제
				if(!files.get(0).isEmpty()) {
					List<String> oldImages=mapper.getAttach(vo.getId());
					for(String oldImage:oldImages) {
						new File(path + File.separator + oldImage).delete();
					}
				}
				//새로운 첨부이미지 추가
				List<String> images=new ArrayList<String>();
				for(MultipartFile attfile:files) {
					if(!attfile.isEmpty()) {
						String image=System.currentTimeMillis()+attfile.getOriginalFilename();
						attfile.transferTo(new File(path+File.separator+image));
						images.add(image);
					}
				}
				vo.setImages(images);
				service.update(vo);
				return "redirect:list";
	}
	
	@RequestMapping(value="/user/delete",method=RequestMethod.POST)
	public String deletePost(UserVO vo) {
		//대표이미지가 있으면 삭제하기
		if(!vo.getImage().equals("")) {
			new File(path+File.separator+vo.getImage()).delete();
		}
		
		//첨부이미지가 있으면 삭제하기
		List<String> images=mapper.getAttach(vo.getId());
		for(String image:images) {
			new File(path+File.separator+image).delete();
		}
		service.delete(vo.getId());
		return "redirect:list";
		
	}
	
	//이미지파일 브라우저에 출력
	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName)throws Exception{
	 ResponseEntity<byte[]> result=null;
	 //display fileName이 있는 경우
	 if(!fileName.equals("")) {
	 File file=new File(path + File.separator + fileName);
	 HttpHeaders header=new HttpHeaders();
	 header.add("Content-Type", Files.probeContentType(file.toPath()));
	 result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
	 }
	 return result;
	}
}
