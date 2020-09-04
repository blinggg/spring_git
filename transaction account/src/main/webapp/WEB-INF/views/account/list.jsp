<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<style>
	#tbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	
</style>
	<title>통장 목록</title>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<h1>[통장 목록]</h1>

	<table border=1 id="tbl">
		<tr class=title>
			<td width=100>계좌번호</td>
			<td width=100>계좌주명</td>
			<td width=200>개설일</td>
			<td width=100>잔액</td>
			<td width=100>거래내역</td>
		</tr>
	<c:forEach items="${list}" var="vo">
		<tr class=row>
			<td>${vo.ano}</td>
			<td>${vo.name}</td>
			<td><fmt:formatDate value="${vo.openDate}" pattern="yyyy년MM월dd일"/></td>
			<td><fmt:formatNumber value="${vo.balance}" pattern="#,###"/></td>
			<td><button onClick="location.href='read?ano=${vo.ano}'">거래내역</button></td>
		</tr>
	</c:forEach>
	</table>
</body>

</html>