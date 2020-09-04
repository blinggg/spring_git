package com.example.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.domain.UserVO;
import com.example.mapper.UserMapper;

@Controller
public class UserController {
	@Autowired
	UserMapper mapper;
	
	//ȸ������ ȭ�� ���̱�
	@RequestMapping("/user/insert")
	public void insert(UserVO vo) {
		
	}
	
	//ȸ�������ϱ�
	@Autowired
	BCryptPasswordEncoder passEncoder;
	@RequestMapping(value="/user/insert",method=RequestMethod.POST)
	public String insertPost(UserVO vo) {
		//������ �ִ� �н����带 ��ȣȭ�ؼ� �ٽ� �н������ �־��ֱ�
		vo.setPass(passEncoder.encode(vo.getPass()));
		mapper.insert(vo);
		return "redirect:/board/list";
	}
	

	
	//�α׾ƿ��ϱ�
	@RequestMapping("/user/logout")
	public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		
		//����Ǿ��ִ� ��Ű���� ��������
		Cookie cookie=WebUtils.getCookie(request, "id");
		if(cookie!=null) {
			cookie.setPath("/");
			//�ð��� 0���� == ��Ű�����
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return "redirect:/board/list";
	}
	
	//�α��� â ���̱�
	@RequestMapping("/user/login")
	public void login(String id) {
		
	}
	
	//�α���â���� �α����� ��
	@RequestMapping(value="/user/login",method = RequestMethod.POST)
	@ResponseBody
	public int loginPost(UserVO vo,HttpSession session,boolean chkLogin,HttpServletResponse response) {
		System.out.println(chkLogin);
		//id�� ���°�
		int result=0;
		//id������ ������ vo
		UserVO readVO=mapper.read(vo.getId());
		//���̵� �����ϴ� ���
		if(readVO!=null) {
			//�����Է��� pass, vo�� pass�� ���ϱ�
			if(passEncoder.matches(vo.getPass(),readVO.getPass())){
				result=2;
				session.setAttribute("id", readVO.getId());
				if(chkLogin) {
					Cookie cookie=new Cookie("id",vo.getId());
					cookie.setPath("/");
					//��Ű�� ����Ǿ� �ִ� �ð����ϱ�
					cookie.setMaxAge(60*60);
					//��Ű �����ϱ�
					response.addCookie(cookie);
					
				}
			}else{
				result=1;
			}
		}

		return result;
	}
	
	
}
