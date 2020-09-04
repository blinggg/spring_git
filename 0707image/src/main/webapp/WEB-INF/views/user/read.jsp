<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<style>
#listFile img {
	width: 150px;
	margin-left: 20px;
}

input[type=file] {
	visibility: hidden;
	height: 0px;
}
</style>
<title>회원정보</title>
</head>
<body>
	<h1>회원정보</h1>
	<form name="frm" action="update" method="post"
		enctype="multipart/form-data">
		<table border=1>
			<tr>
				<td>회원코드</td>
				<td><input type="text" value="${vo.id}" name="id" readonly></td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" value="${vo.name}" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" value="${vo.pass}" name="pass"></td>
			</tr>
			<tr>
				<td>대표이미지</td>
				<td><input type="file" name="file"> 
					<c:if test="${vo.image!=null && vo.image!=''}">
						<img id="image" src="/display?fileName=${vo.image}" width=100>
					</c:if> 
					<c:if test="${vo.image==null || vo.image==''}">
						<img id="image" src="http://placehold.it/100x80" width=100>
					</c:if> 
					
					<input type="text" name="image" value="${vo.image}"></td>
			</tr>
			<tr>
				<td><input type="button" value="추가이미지" id="btnImage"></td>
				<td><input type="file" name="files" accept="image/*" multiple>
					<div id="listFile">
						<c:forEach items="${list}" var="image">
							<img src="/display?fileName=${image}">
						</c:forEach>
					</div></td>
			</tr>
		</table>
		<input type="submit" value="수정"> 
		<input type="button" value="삭제" id="btnDelete"> 
		<input type="reset" value="취소">
		<input type="button" value="목록" id="btnList">
	</form>
</body>
<script>
	//삭제버튼을 눌렀을 때
	$("#btnDelete").on("click", function(){
		if(!confirm("회원정보를 삭제하시겠습니까?")) return;
		frm.action="delete";
		frm.submit();
		alert("삭제되었습니다!");
	});
	
	//상품이미지 버튼
	$("#btnImage").on("click", function() {
		$(frm.files).click();
	});

	//목록버튼
	$("#btnList").on("click", function() {
		location.href = "/pro/list";
	});

	//이미지 클릭했을떄
	$("#image").on("click", function() { //이미지클릭할때 file클릭한거처럼 됨
		$(frm.file).click();
	});

	//파일업로드
	$(frm.file).on("change", function() {
		var file = $(frm.file)[0].files[0]; //1번째 input type="file"에서 이미지 1개만
		$("#image").attr("src", URL.createObjectURL(file));
	});

	//파일업로드(여러개)
	$(frm.files).on("change", function() {
		var files = $(frm.files)[0].files;
		var html = "";
		$.each(files, function(index, file) {
			html += "<img src='" + URL.createObjectURL(file) + "'>";
		});
		$("#listFile").html(html);
	});
</script>
</html>