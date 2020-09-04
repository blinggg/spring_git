<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[사용자목록]</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
	#UserList{width:500px;border-collapse:collapse;border:1px solid #BFB4AC;text-align:center;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
</style>
</head>
<body>
	<h1>[사용자목록]</h1>
	<table id="UserList">
		<tr class="title">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>성명</td>
			<td>point</td>
			<td>send</td>
			<td>receive</td>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class="row">
			<td class="id">${vo.id}</td>
			<td>${vo.pass}</td>
			<td class="name">${vo.name}</td>
			<td>${vo.point}점</td>
			<td><button class=btnSend>📝</button></td>
			<td><button class=btnReceived>💌</button></td>
		</tr>
		</c:forEach>
	</table>
</body>
<script>
	var id, name, row;
	$(".btnSend").on("click",function(){
		row=$(this).parent().parent();
		var id=row.find(".id").html();
		var name=row.find(".name").html();
		location.href="listSend?id="+id
	})
	
	$(".btnReceived").on("click",function(){
		row=$(this).parent().parent();
		var id=row.find(".id").html();
		var name=row.find(".name").html();
		
		location.href="listReceived?id="+id
	})
</script>
</html>