<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글읽기</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<h1>[Board Read]</h1>
	<form name="frm" method="post" action="update">
		<input type="hidden" value="${id}">
		<input type="hidden" name="page" value="${param.page}">
		<input type="hidden" name="bno" value="${vo.bno}">
		<table border=1>
			<tr>
				<th width=100>Title</th>
				<td><input type="text" name="title" value="${vo.title}" size=50></td>
			</tr>
			<tr>
				<th>Writer</th>
				<td>${vo.writer}</td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${vo.regdate}</td>
			</tr>
			<tr>
				<td colspan=2>
					<textarea rows="10" cols="67">${vo.content}</textarea>
				</td>
			</tr>						
		</table>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
		<c:if test="${id==vo.writer}">
			<input type="button" value="삭제" id="btnDelete">
		</c:if>
		<input type="button" value="목록" id="btnList">
	</form>
	<hr>
	<jsp:include page="../reply/reply.jsp"/>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("수정하실래요?")) return;
		frm.submit();
	});
	
	$("#btnDelete").on("click", function(){
		if(!confirm("삭제하실래요?")) return;
		var bno=$(frm.bno).val();
		$.ajax({
			type:"get",
			url:"/replyCount",
			data:{"bno":bno},
			success:function(data){
				if(data==0){
					frm.action="delete";
					frm.submit();
				}else{
					alert("댓글이 " + data + "개 있어 삭제 불가능!");
				}
			}
		});
	});
	
	$("#btnList").on("click", function(){
		var page=$(frm.page).val();
		location.href="list?page="+page;
	});
</script>
</html>