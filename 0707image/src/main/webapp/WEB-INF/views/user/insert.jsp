<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<style>
	input[type=file]{visibility:hidden; height:0px;}
	#listFile img {width:150px;margin-left:20px;}
</style>
<title>회원등록</title>
</head>
<body>
	<h1>회원등록</h1>
	<form name="frm" action="insert" method="post" enctype="multipart/form-data">
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>			
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pass"></td>
			</tr>						
			<tr>
				<td>대표이미지</td>
				<td>
					<img id="image" src="http://placehold.it/150x120" width=150>
					<input type="file" name="file">
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="이미지" id="btnImage">
				</td>
				<td>
					<input type="file" name="files" accept="image/*" multiple>
					<div id="listFile"></div>
				</td>
				
			</tr>
							
		</table>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
		<input type="button" value="목록">
	</form>
</body>
<script>
	//상품이미지 버튼
	$("#btnImage").on("click",function(){
		$(frm.files).click();
	});
	
	//목록버튼
	$("#btnList").on("click",function(){
		location.href="/pro/list";
	});
	
	//이미지 클릭했을떄
	$("#image").on("click",function(){	//이미지클릭할때 file클릭한거처럼 됨
		$(frm.file).click();
	});
	
	//파일업로드
	$(frm.file).on("change",function(){
		var file=$(frm.file)[0].files[0];	//1번째 input type="file"에서 이미지 1개만
		$("#image").attr("src",URL.createObjectURL(file));
	});
	
	//파일업로드(여러개)
	$(frm.files).on("change",function(){
		var files=$(frm.files)[0].files;
		var html="";
		$.each(files, function(index, file){
			html+="<img src='" + URL.createObjectURL(file) + "'>";
		});
		$("#listFile").html(html);
	});
</script>
</html>