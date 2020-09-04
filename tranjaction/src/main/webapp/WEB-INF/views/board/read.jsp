<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>게시글읽기</title>
</head>
<body>
	<h1>게시글읽기</h1>
		<form name="frm1" action="list">
		현재페이지:<input type="text" name="page" value="${cri.page}">
	</form>
		<form name="frm" action="update" method="post">
		bno:<input type="text" name="bno" value="${vo.bno}">
		<input type="text" name="page" value="${cri.page}">
		<table border=1 width=500>
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
			<tr>
				<td>작성일</td>
				<td><input type="text" name="regdate" value="${vo.regdate}" size=10></td>
			</tr>			
		</table>
		<input type="submit" value="수정"> 
		<input type="reset" value="취소"> 
		<input type=button value=삭제 id=btnDelete>
		<input type="button" value="목록" id=btnList>
	</form>
	<hr>
	<jsp:include page="../reply/reply.jsp"/>
</body>
<script>
//수정버튼을 눌렀을 때
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("수정하실?")) return;
		frm.submit();
	});
	
	//삭제버튼을 눌렀을 때
	$("#btnDelete").on("click", function(){
		if(!confirm("삭제하싈?")) return;
		var bno=$(frm.bno).val();
		alert(bno);
		$.ajax({
			type:"post",
			url:"/replyCount",
			dataType:"json",
			data:{"bno":bno},
			success:function(count){
				//alert(".");
				if(count==0){
					alert("삭제되었습니다.");
					frm.action="delete";
					frm.submit();
				}else{
					alert("댓글이"+count+ " 개가 있으므로 삭제불가합니다!")
				}
			}
		});
	});
	
	$("#btnList").on("click",function() {
		frm1.submit();
	});


</script>
</html>