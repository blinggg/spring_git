<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>보낸메시지</title>
<style>
	#tbl,#stbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	#stbl{border-top:5px solid #BFB4AC;margin-top:10px;}
</style>
</head>
<script>
</script>
<body>
		<h1>[보낸 메시지 목록]</h1>
		<table id="tbl" border=1 width=500>
			<tr>
				<td class=title>보낸이</td>
				<td>
					<span id="name">${vo.name}</span>
					<span id="point">${vo.point}</span>
				</td>
			</tr>
			<tr>
				<td width=100  class=title>받는이</td>
				<td>
					<select id="receiver">
					<c:forEach items="${list}" var="vo">
						<option value="${vo.id}">${vo.id}-${vo.name}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td width=100 class=title>내용</td>
				<td><input type="text" id="message" size=20></td>
			</tr>
		</table>
		
		<input type="button" value="보내기" id="btnSend"> 
		
	<table id="stbl" border=1 width=500></table>
	<script id="stemp" type="text/x-handlebars-template">
		<tr class="title">
			<td>mid</td>
			<td>이름/받는사람</td>
			<td>메시지</td>
		</tr>	
	{{#each .}}
		<tr class="row">
			<td>{{mid}}</td>
			<td>{{name}}:{{receiver}}</td>
			<td>{{message}}</td>
		</tr>
		{{/each}}
	</script>
</body>
<script>
	var id="${vo.id}";
	getList();
	
	//보내기버튼을 눌렀을 때
	$("#btnSend").on("click", function(){
		//alert(id);
		
		var sender=id;
		var receiver=$("#receiver").val();
		var message=$("#message").val();
		if(message==""){
			alert("메시지 내용을 입력하세요!");
			$("#message").focus();
			return;
		}
		
		$.ajax({
			type:"post",
			url:"/message/insert",
			data:{"sender":sender,"receiver":receiver,"message":message},
			success:function(){
				alert("전송완료!");
				$("#message").val("");
				var point=parseInt($("#point").html());
				$("#point").html(point+10);
				getList();

			}
		});
	});
	
	//보낸메시지 목록 출력하기
	function getList(){
	$.ajax({
		type:"get",
		url:"/list/send",
		dataType:"json",
		data:{"id":id},
		success:function(data){
			var temp = Handlebars.compile($("#stemp").html());
			$("#stbl").html(temp(data));

		}
	});
}

</script>
</html>