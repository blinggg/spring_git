package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.AirVO;
import com.example.mapper.AirMapper;

@Controller
public class AirController {
	@Resource(name="uploadPath")
	private String path;
	
	@Autowired
	AirMapper mapper;
	
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(AirVO vo) throws Exception {
		System.out.println(vo.toString());
		//mapper.insert(vo);
		String image=download(vo.getImage());
		vo.setImage(image);
		AirVO readVO=mapper.read(vo.getTitle());
		if(readVO==null) {
			System.out.println(vo.toString());
			mapper.insert(vo);
		}
		
	}
	
	
	@RequestMapping("/air")
	public void list(Model model) {
		model.addAttribute("list", mapper.list());
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public String download(String image)throws Exception{
		System.out.println(image);
		URL url=new URL(image);
		InputStream in=url.openStream();
		String file=System.currentTimeMillis()+".jpg";
		OutputStream out=new FileOutputStream("c:/zzz/air/"+file);
		FileCopyUtils.copy(in, out);
		return file;
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
