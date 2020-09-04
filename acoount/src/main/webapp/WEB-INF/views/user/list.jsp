<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<style>
	#tbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	
</style>
<title>사용자목록</title>
</head>
<body>
	<h1>사용자목록</h1>
	<table id=tbl>
		<tr class=title>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>포인트</td>
			<td>보낸메시지</td>
			<td>받은메시지</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class=row>
				<td class="id">${vo.id}</td>
				<td class="pass">${vo.pass}</td>
				<td class="name">${vo.name}</td>
				<td class="point">${vo.point}점</td>
				<td><button onClick="location.href='send?id=${vo.id}'">📝</button></td>
				<td><button onClick="location.href='receive?id=${vo.id}'">💌</button></td>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>