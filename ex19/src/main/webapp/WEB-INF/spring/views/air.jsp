<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta charset="UTF-8">
<title>[tbl_airbnb 저장 목록]</title>
</head>
<body>
	<h1>tbl_airbnb 저장 목록</h1>
	<table border=1>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>
					<img id="image" src="/display?fileName=${vo.image}" width=200 height=200>
				</td>
				<td width=500>
					<div class="title">${vo.title}</div>
					<br>
					<div>별점:${vo.rating}</div>
					<br>
					<div>구성</div>
					<div>${vo.info}</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>