<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<style>
	
	input[type=file]{visibility:hidden; height:0px;}
</style>
<title>상품정보</title>
</head>
<body>
	<h1>상품정보</h1>
	<form name="frm" action="update" method="post" enctype="multipart/form-data">
		<table border=1>
			<tr>
				<td>상품코드</td>
				<td><input type="text" value="${vo.pcode}" name="pcode" readonly></td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" value="${vo.pname}" name="pname"></td>
			</tr>			
			<tr>
				<td>상품가격</td>
				<td><input type="text" value="${vo.price}" name="price"></td>
			</tr>						
			<tr>
				<td>대표이미지</td>
				<td>
					<input type="file" name="file">
					<c:if test="${vo.image!=null && vo.image!=''}">
						<img id="image" src="/display?fileName=${vo.image}" width=100 >
					</c:if>
					<c:if test="${vo.image==null || vo.image==''}">
						<img id="image" src="http://placehold.it/100x80" width=100>
					</c:if>
					<input type="text" name="image" value="${vo.image}">
				</td>
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
		if(!confirm("상품정보를 삭제하시겠습니까?")) return;
		frm.action="delete";
		frm.submit();
		alert("삭제되었습니다!");
	});
	
	//수정버튼을 눌렀을 대
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("상품정보를 수정하시겠습니까?")) return;
		frm.submit();
	});
	
	//목록버튼을 눌렀을 때
	$("#btnList").on("click", function(){
		location.href="list";
	});

	//이미지를 클릭했을 때
	$("#image").on("click", function(){
		$(frm.file).click();
	});
	
	
	$(frm.file).on("change", function(){
		var file=$(frm.file)[0].files[0];
		$("#image").attr("src",URL.createObjectURL(file));
		
	});
</script>
</html>