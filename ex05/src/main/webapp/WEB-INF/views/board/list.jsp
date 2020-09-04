<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Bulletin Board</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<style>
		.row:hover{background:gray; color:white;}
		.row{cursor:pointer;}
		a{color:black; text-decoration:none; }
		.active{color:red;}
	</style>
</head>
<body>
	<h1>[ Bulletin Board ]</h1>
	<a href="insert">insert </a> [게시글 수: <span>${pm.totalCount}</span>건]
	<form name="frm" action="list">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="bno">
		<select name="searchType">
			<option value="title" <c:out value="${cri.searchType=='title'?'selected':''}"/>>제목</option>
			<option value="writer" <c:out value="${cri.searchType=='writer'?'selected':''}"/>>작성자</option>
			<option value="content" <c:out value="${cri.searchType=='content'?'selected':''}"/>>내용</option>
		</select>
		<input type="text" name="keyword" value="${cri.keyword}">
		<input type="submit" value="검색">
	</form>
	<table class="tbl" border=1 width=700>
		<tr>
			<td width=50>번호</td>
			<td width=450>제목</td>
			<td width=100>작성자</td>
			<td width=100>작성일</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class="row">
				<td class="bno">${vo.bno}</td>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
	<div id="pagination">
		<c:if test="${pm.prev}">
			<a href="${pm.startPage-1}">◀</a>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i"> 
			<c:if test="${cri.page==i}">
				<a href="${i}" class="active"><b> [${i}] </b></a>
			</c:if>
			<c:if test="${cri.page!=i}">
				<a href="${i}"> [${i}] </a>
			</c:if>
		</c:forEach>
		<c:if test="${pm.next}">
			<a href="${pm.endPage+1}">▶</a>
		</c:if>
	</div>
</body>
<script>
	$(frm).submit(function(){
		$(frm.page).val(1);
	});

	$("#pagination").on("click","a", function(e) {
		e.preventDefault();
		var page=$(this).attr("href");
		$(frm.page).val(page);
		frm.submit();
	});

	$(".row").on("click", function() {
		var bno=$(this).find(".bno").html();
		$(frm.bno).val(bno);
		frm.action="read";
		frm.submit();
		//location.href="read?bno="+bno;
	});
</script>
</html>