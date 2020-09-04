<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글쓰기</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<h1>[Board Insert]</h1>
	<form name="frm" method="post" action="insert">
		<input type="hidden" name="writer" value="${id}">
		<table border=1>
			<tr>
				<th width=100>Title</th>
				<td><input type="text" name="title" value="" size=50></td>
			</tr>
			<tr>
				<td colspan=2>
					<textarea rows="10" cols="67" name="content"></textarea>
				</td>
			</tr>						
		</table>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
		<input type="button" value="목록" id="btnList">
	</form>
	<hr>
</body>
<script>
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("저장하실래요?")) return;
		frm.submit();
	});
	
	$("#btnList").on("click", function(){
		var page=$(frm.page).val();
		location.href="list";
	});
</script>
</html>