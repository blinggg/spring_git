<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<style>
.box {
	width: 100px;
	height: 200px;
	padding: 5px;
	margin: 5px;
	background: #BBD4E5;
	color: white;
	float: left;
	font-size: 15px;
}

a {
	color: black;
}

#search{width:480px;background: #BBD4E5;margin-bottom:10px;text-align:center;}

</style>
<title>[회원목록]</title>
</head>
<body>
	<h1>회원목록</h1>
	<div style="width: 480px; background: #CFF0F8; overflow: hidden;">
		<c:forEach items="${list}" var="vo">
			<div class="box">
				<c:if test="${vo.image!=null && vo.image!=''}">
					<img id="image" src="/display?fileName=${vo.image}" width=100 height=130>
				</c:if>
				<c:if test="${vo.image==null || vo.image==''}">
					<img id="image" src="http://placehold.it/100x80">
				</c:if>
				<div>
					<a href="read?id=${vo.id}">${vo.id}</a>
				</div>
				<div>${vo.name}</div>
			</div>
		</c:forEach>
	</div>
	<button onclick="location.href='insert'">회원등록</button>
</body>
</html>