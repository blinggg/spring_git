<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>[주소정보]</title>
</head>
<body>
	<h1>[주소정보]</h1>
	<form name=frm action=update method=post>
		<input type=hidden value="${vo.id}">
		<table id=tbl>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${vo.id}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${vo.name}"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value="${vo.address}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" value="${vo.tel}"></td>
			</tr>
		</table>
		<input type=submit value=수정>
		<input type=button value=삭제 id=btnDelete>
		<input type=reset value=취소>
		<input type=button value=목록 Onclick="location.href='list'">
	</form>
</body>
<script>
	$("#btnDelete").on("click", function(){
		if(!confirm("삭제하시겠습니까?")) return;
		frm.action="delete";
		//frm.method="post";
		frm.submit();
	});
	
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("수정하시겠습니까?")) return;
		frm.submit();
	});
</script>
</html>