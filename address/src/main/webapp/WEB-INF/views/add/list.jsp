<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<style>
	#tbl{width:500px;text-align:center;}
	.title{background:green;color:white;}
	
</style>
<title>[주소목록]</title>
</head>
<body>
	<h1>주소목록</h1>
	<button Onclick="location.href='insert'">입력</button>
		<table id=tbl border=1>
		<tr class=title>
			<td>아이디</td>
			<td>이름</td>
			<td>주소</td>
			<td>전화번호</td>
		</tr>
		<c:forEach items="${list}" var="vo"> <!-- vo의 필드명과 같이 써줘야함 -->
			<tr class=row>
				<td class=id>${vo.id}</td>
				<td class=name>${vo.name}</td>
				<td class=address>${vo.address}</td>
				<td class=tel>${vo.tel}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
	$(".row").on("click", function(){
		var id=$(this).find(".id").html();
		//alert(id);
		location.href="read?id="+id;
		
	});

</script>
</html>