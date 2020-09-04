<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<style>
	
	input[type=file]{visibility:hidden; height:0px;}
</style>
<title>상품등록</title>
</head>
<body>
	<h1>상품등록</h1>
	<form name="frm" action="insert" method="post" enctype="multipart/form-data">
		<table border=1>
			<tr>
				<td>상품코드</td>
				<td><input type="text" name="pcode"></td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="pname"></td>
			</tr>			
			<tr>
				<td>상품가격</td>
				<td><input type="text" name="price"></td>
			</tr>						
			<tr>
				<td>대표이미지</td>
				<td>
					<img id="image" src="http://placehold.it/150x120" width=150>
					<input type="file" name="file">
				</td>
			</tr>
							
		</table>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
		<input type="button" value="목록">
	</form>
</body>
<script>

	//이미지를 클릭했을 때
	$("#image").on("click", function(){
		$(frm.file).click();
	});
	
	$(frm.file).on("change", function(){
		var file=$(frm.file)[0].files[0];
		$("#image").attr("src",URL.createObjectURL(file));
		var src=$("#image").attr("src");
		alert(src);
	});
</script>
</html>