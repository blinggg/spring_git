<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>게시글 읽기</title>
</head>
<body>
	<h1>[게시글 읽기]</h1>
	
	<form name="frm1" action="list" >
		<input type="text" name="page" value="${cri.page}">
 		<input type="text" name="searchType" value="${cri.searchType}">
 		<input type="text" name="keyword" value="${cri.keyword}">

	</form>
	
	<form name="frm" action="update" method="post">
	<input type=hidden value="${vo.bno}" name=bno>
		<input type="text" name="page" value="${cri.page}">
 		<input type="text" name="searchType" value="${cri.searchType}">
 		<input type="text" name="keyword" value="${cri.keyword}">
		<table class="tbl" border=1 width=500>
			<tr>
				<td width=100>제목</td>
				<td><input type="text" name="title" size=50 value="${vo.title}"></td>
			</tr>
			<tr>
				<td width=100>내용</td>
				<td><textarea rows="10" cols="52" name="content">"${vo.content}"</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${vo.writer}" readonly size=10></td>
			</tr>
		</table>
		<input type="submit" value="수정"> 
		<input type="reset" value="취소"> 
		<input type=button value=삭제 id=btnDelete>
		<input type="button" value="목록" id=btnList>
	</form>
</body>
<script>
	$("#btnList").on("click", function(){
		frm1.submit();
	});
	
	//게시글 수정하기
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("게시글을 수정하시겠습니까?")) return;
		frm.submit();
	});
	
	//게시글 삭제하기
	$("#btnDelete").on("click", function(){
		if(!confirm("게시글을 삭제하시겠습니까?")) return;
		frm.action="delete" //post로 action 실행 location.href는 get으로 표현함~!
		frm.submit();
	});
	

</script>
</html>