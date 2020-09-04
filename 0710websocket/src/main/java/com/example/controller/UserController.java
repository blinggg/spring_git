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
	
	//회원가입 화면 보이기
	@RequestMapping("/user/insert")
	public void insert(UserVO vo) {
		
	}
	
	//회원가입하기
	@Autowired
	BCryptPasswordEncoder passEncoder;
	@RequestMapping(value="/user/insert",method=RequestMethod.POST)
	public String insertPost(UserVO vo) {
		//기존에 있는 패스워드를 암호화해서 다시 패스워드로 넣어주기
		vo.setPass(passEncoder.encode(vo.getPass()));
		mapper.insert(vo);
		return "redirect:/board/list";
	}
	

	
	//로그아웃하기
	@RequestMapping("/user/logout")
	public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		
		//저장되어있는 쿠키값을 가져오기
		Cookie cookie=WebUtils.getCookie(request, "id");
		if(cookie!=null) {
			cookie.setPath("/");
			//시간을 0으로 == 쿠키지우기
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return "redirect:/board/list";
	}
	
	//로그인 창 보이기
	@RequestMapping("/user/login")
	public void login(String id) {
		
	}
	
	//로그인창에서 로그인할 때
	@RequestMapping(value="/user/login",method = RequestMethod.POST)
	@ResponseBody
	public int loginPost(UserVO vo,HttpSession session,boolean chkLogin,HttpServletResponse response) {
		System.out.println(chkLogin);
		//id가 없는것
		int result=0;
		//id값으로 리드한 vo
		UserVO readVO=mapper.read(vo.getId());
		//아이디가 존재하는 경우
		if(readVO!=null) {
			//내가입력한 pass, vo의 pass와 비교하기
			if(passEncoder.matches(vo.getPass(),readVO.getPass())){
				result=2;
				session.setAttribute("id", readVO.getId());
				if(chkLogin) {
					Cookie cookie=new Cookie("id",vo.getId());
					cookie.setPath("/");
					//쿠키가 저장되어 있는 시간정하기
					cookie.setMaxAge(60*60);
					//쿠키 저장하기
					response.addCookie(cookie);
					
				}
			}else{
				result=1;
			}
		}

		return result;
	}
	
	
}
