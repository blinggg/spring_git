<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	#tbl,#stbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	#stbl{border-top:5px solid #BFB4AC;margin-top:10px;}
</style>
<title>Send Massage</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<h1>[Send Massage]</h1>
	<table id="stbl">
		<tr>
			<td width=100>sender</td>
			<td>
			${read.name}&nbsp;&nbsp; 포인트 :
			<span id="point">${read.point}</span>점
			</td>
		</tr>
		<tr>
			<td width=100>Receiver</td>
			<td>
				<select id="receiver">
				
				<c:forEach items="${list}" var="vo">
					<c:if test="${read.id!=vo.id}">
						<option id="${vo.id}" value="${vo.id}">${vo.id}-${vo.name}</option>
					</c:if>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td width=100>Content</td>
			<td><input type="text" size=50 value="" id="message"></td>
		</tr>
	</table>
	<input type="button" value="send" id="btnSend">
	
	
	<table id="tbl" border=1></table>
	<script id="temp" type="text/x-handlebars-template">
			<tr>
				<td width=150>mid</td>
				<td width=150>sender</td>
				<td width=220>message</td>
			</tr>
		{{#each .}}
			<tr class="row">
				<td class="mid">{{mid}}</td>
				<td>{{receiver}}:{{name}}</td>
				<td>{{message}} {{{printStyle readDate}}}<button>삭제</button></td>
			</tr>
		{{/each}}
	</script>
</body>
<script>
	Handlebars.registerHelper("printStyle",function(readDate){
		var src;
		if(readDate==null) src="<b>[읽지 않음]</b>";
		return src;
	});

var id="${read.id}";
getList();

	$("#tbl").on("click",".row button",function(){
		var row=$(this).parent().parent();
		var mid=row.find(".mid").html();
		
		$.ajax({
			type:"get",
			url:"/message/sdelete",
			data:{"mid":mid},
			success:function(){
				alert("삭제 완료");
				getList();
			}
		});
	});



	function getList(){
		$.ajax({
			type:"get",
			url:"/list/send",
			data:{"id":id},
			dataType:"json",
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				 $("#tbl").html(temp(data));
				 
			}
		});
	}
	

	
	$("#btnSend").on("click",function(){
		var sender=id;
		var receiver=$("#receiver").val();
		var message=$("#message").val();
		
		$.ajax({
			type:"post",
			url:"/message/insert",
			data:{"sender":sender,"receiver":receiver,"message":message},
			success:function(){
				alert("전송 완료!");
				$("#message").val("");
				var point=parseInt($("#point").html());
				$("#point").html(point+10);
				getList();
			}
		});
	});
</script>
</html>