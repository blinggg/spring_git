package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			 throws Exception {
		
	 if(request.getSession().getAttribute("id") == null){
		 String path=request.getServletPath();
		 String query=request.getQueryString();
		 if(query !=null) {
			 //read 할때 bno가 필요하므로
			 query="?"+query;
		 }else {
			 //insert 작업을 할때
			 query="";
		 }
		 
		 //dest에 내가가고싶은 경로 저장
		 request.getSession().setAttribute("dest", path+query);
		 System.out.println(path+query);
		 response.sendRedirect("/user/login");
	 }
	 	return super.preHandle(request, response, handler);
	 }
	
	
}
