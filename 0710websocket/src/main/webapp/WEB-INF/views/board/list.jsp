<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시판 목록</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<style>
		a{text-decoration:none;}
		.active{color:red;}
		.row{cursor:pointer;}
		.row:hover{background:gray; color:white;}
	</style>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<h1>[Board List]</h1>
	전체글수: ${pm.totalCount}
	<input type="hidden" id="page" value="${pm.cri.page}">
	<table border=1 id="tbl">
		<tr>
			<th width=50>No.</th>
			<th width=300>Title.</th>
			<th width=100>Writer</th>
			<th width=200>Date</th>
			<th width=100>View</th>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class="row">
			<td class="bno">${vo.bno}</td>
			<td>${vo.title}[${vo.replycnt}]</td>
			<td>${vo.writer}</td>
			<td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd kk:mm:ss"/></td>
			<td>${vo.viewcnt}</td>
		</tr>
		</c:forEach>
	</table>
	<div id="pagination">
        <c:if test="${pm.prev}">
            <a href="${pm.startPage-1}">◀</a>
        </c:if>
        <c:forEach begin="${pm.startPage}"  end="${pm.endPage}" var="i">
            <c:if test="${pm.cri.page == i }">
                [<a href="${i}" class='active'>${i}</a>]
            </c:if>
            <c:if test="${pm.cri.page != i }">
                [<a href="${i}">${i}</a>]
            </c:if>
        </c:forEach>
        <c:if test="${pm.next}">
            <a href="${pm.endPage+1}">▶</a>
        </c:if>
    </div>
</body>
<script>
	$("#tbl").on("click", ".row", function(){
		var bno=$(this).find(".bno").html();
		var page=$("#page").val();
		location.href="read?bno="+bno+"&page="+page;
	});
	
	$("#pagination").on("click", "a", function(e){
		e.preventDefault();
		var page=$(this).attr("href");
		$("#page").val(page)
		location.href="list?page="+page;
	});
</script>
</html>