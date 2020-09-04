<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>bulletin board reading</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<h1>[ bulletin board reading ]</h1>
	<form name="frm1" action="list">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="searchType" value="${cri.searchType}">
		<input type="hidden" name="keyword" value="${cri.keyword}">
	</form>
	<form name="frm" action="update" method="post">
		<input type="hidden" name="bno" value="${vo.bno}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="searchType" value="${cri.searchType}">
		<input type="hidden" name="keyword" value="${cri.keyword}">
		<table class="tbl" border=1 width=500>
			<tr>
				<td width=100>제목</td>
				<td><input type="text" name="title" size=50 value="${vo.title}"></td>
			</tr>
			<tr>
				<td width=100>내용</td>
				<td><textarea rows="10" cols="52" name="content">${vo.content}</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" readonly size=10  value="${vo.writer}"></td>
			</tr>
		</table>
		<input type="submit" value="수정"> 
		<input type="reset" value="취소"> 
		<input type="button" value="삭제" id="btnDelete">
		<input type="button" value="목록" id="btnList">
	</form>
</body>
<script>
	$("#btnList").on("click",function() {
		frm1.submit();
	});

	$(frm).submit(function(e) {
		e.preventDefault();
		if(!confirm("수정하시겠습니까?")) return;
		frm.submit();
		
	});
	
	$("#btnDelete").on("click", function() {
		if(!confirm("삭제하시겠습니까?")) return;
		frm.action="delete";
		frm.submit();
	});
</script>
</html>