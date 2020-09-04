<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>사용자목록</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h1>[사용자목록]</h1>
	<table border=1 width=500 id="tbl">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>성명</td>
			<td>Point</td>
			<td>보낸메시지</td>
			<td>받은메시지</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class="row">
				<td class="id">${vo.id}</td>
				<td>${vo.pass}</td>
				<td>${vo.name}</td>
				<td>${vo.point}</td>
				<td><button class="send">보낸메시지</button></td>
				<td><button class="receive">받은메시지</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
$("#tbl").on("click",".row .send",function(){
	var id=$(this).parent().parent().find(".id").html();
	location.href="/user/send?id="+id;
});
$("#tbl").on("click",".row .receive",function(){
	var id=$(this).parent().parent().find(".id").html();
	location.href="/user/receive?id="+id;
});
</script>
</html>
