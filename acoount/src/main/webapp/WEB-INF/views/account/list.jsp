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
<title>계좌목록</title>
</head>
<body>
	<h1>계좌목록</h1>
	<table id=tbl>
		<tr class=title>
			<td>계좌번호</td>
			<td>계좌주</td>
			<td>통장개설일</td>
			<td>계좌잔액</td>
			<td>통장내역</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class=row>
				<td class="ano">${vo.ano}</td>
				<td class="name">${vo.name}</td>
				<td><fmt:formatDate value="${vo.openDate}" pattern="yyyy-MM-dd kk:mm:ss"/></td>
 				<td><fmt:formatNumber value="${vo.balance}" pattern="#,###"/></td>
 				<td><button onClick="location.href='read?ano=${vo.ano}'">통장내역</button></td>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>