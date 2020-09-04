<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<title>상품 정보</title>
	<style>
		input[type=file]{visibility:hidden; height:0px;}
		#listFile img{width:100px;margin-left:15px;}
	</style>
</head>
<body>
	<h1>[상품 정보]</h1>
	<form name="frm" action="update" method="post" enctype="multipart/form-data">
		<table border=1>
			<tr>
				<td width=100>상품코드</td>
				<td width=400><input type="text" name="pcode" value="${read.pcode}" readonly></td>
			</tr>
			<tr>
				<td width=100>상품이름</td>
				<td width=400><input type="text" name="pname" value="${read.pname}"></td>
			</tr>
			<tr>
				<td width=100>상품가격</td>
				<td width=400><input type="text" name="price" value="${read.price}"></td>
			</tr>
			<tr>
				<td width=100>대표이미지</td>
				<td width=400>
					<input type="file" name="file">
					<c:if test="${read.image!=null && read.image!=''}">
						<img src="/display?fileName=${read.image}" width=150 height=120 id="image">
					</c:if>
					<c:if test="${read.image==null || read.image==''}">
						<img src="http://placehold.it/150x120" width=150 id="image">
					</c:if>
					<input type="hidden" name="image" value="${read.image}">
				</td>
			</tr>
			<tr>
				<td width=100>
					<input type="button" value="상품이미지" id="btnImage">
				</td>
				<td width=400 height=150>
					<input type="file" name="files" accept="image/*" multiple>
					<div id="listFile">
						<c:forEach items="${list}" var="image">
							<img src="/display?fileName=${image}">
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
		<input type="button" value="삭제" id="btnDelete">
		<input type="button" value="목록" id="btnList">
	</form>
</body>
<script>
	//상품이미지 버튼
	$("#btnImage").on("click",function(){
		$(frm.files).click();
	});

	//삭제버튼
	$("#btnDelete").on("click",function(){
		if(!confirm("삭제하시겠습니까?")) return;
		frm.action="delete";
		frm.submit();
		alert("삭제되었습니다!");
	});
	
	//수정버튼
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("수정하시겠습니까?")) return;
		frm.submit();
		alert("수정되었습니다!");
	});

	//목록버튼
	$("#btnList").on("click",function(){
		location.href="/pro/list";
	});

	//이미지 눌렀을때
	$("#image").on("click",function(){	//이미지클릭할때 file클릭한거처럼 됨
		$(frm.file).click();
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
	
	$(frm.file).on("change",function(){
		var file=$(frm.file)[0].files[0];	//1번째 input type="file"에서 이미지 1개만
		$("#image").attr("src",URL.createObjectURL(file));
	});
</script>
</html>