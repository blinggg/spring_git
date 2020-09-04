<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <style>
		.item{width:200px;margin-left:50px;}
		menu{background:#F2BFAB;color:white;padding:10px;}
		#menu a{text-decoration:none;color:black;}
		#menu a:hover{background:#E7DBD3;padding:10px;color:white;}
	</style>
    
<div id="menu">
	<c:if test="${id!=null}">
	<span class="item"><a href="/account/list?id=${id}">내통장목록</a></span>
	<span class="item"><a href="/user/receive?id=${id}">받은메시지</a></span>
	<span class="item"><a href="/user/send?id=${id}">보낸메시지함</a></span>

		<span class="item">
			${id}!${name}님🙋‍♀️
			<a href="/user/logout">로그아웃</a></span>
	</c:if>
	
	<c:if test="${id==null}">
		<span class="item">
			<a href="/user/login">로그인</a></span>
	</c:if>
	

</div>
