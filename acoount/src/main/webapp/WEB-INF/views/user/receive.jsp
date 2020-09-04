<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[받은메시지목록]</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
	#tbl,#rtbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	#stbl{border-top:5px solid #BFB4AC;margin-top:10px;}
</style>
</head>
<body>
	<h1>[받은 메시지 목록]</h1>
	<div style="margin-bottom: 10px;">
		<table id=tbl border=1 width=500>
			<tr>
				<td>받은이:<span id="name">${vo.name}</span></td>
				<td>포인트:<span id="point">${vo.point}</span>점
				</td>
			</tr>
		</table>
	</div>
	<table id="rtbl" border=1 width=500></table>
	<script id="rtemp" type="text/x-handlebars-template">
		{{#each .}}
		<tr class=row {{printStyle readDate}}>
			
			<td class="mid">{{mid}}</td>
			<td>{{sender}}-{{name}}</td>
			<td>{{message}}</td>
			<td><button class="btnRead">👀</button></td>
		</tr>
		{{/each}}
	</script>
	<div class="message">
		보낸이:<span id="sender"></span><br>
		내용:<span id="message"></span><br>
		발신일:<span id="sendDate"></span><br>
		Read Date:<span id="readDate"></span><br>
	</div>
</body>
<script>
	Handelbars.registerHelper("printStyle", function(readDate){
		var src;
		if(readDate==null) src="style=color:red;";
		return src;
	});
	
	var id="${vo.id}";
	getList();
	
	$(".message").hide();
	
	$("#rtbl").on("click", ".row button", function(){
		var row=$(this).parent().parent();
		var mid=row.find(".mid").html();
		
		$.ajax({
			type:"get",
			url:"/message/read",
			dataType:"json",
			data:{"mid":mid},
			success:function(data){
				$("#sender").html(data.sender + ":" + data.name);
				$("#message").html(data.message);
				$("#sendDate").html(data.sendDate);
				$("#readDate").html(data.readDate);
				$(".message").show();
				
			$.ajax({
				type:"get",
				url:"/user/getUser",
				dataType:"json",
				data:{"id":id},
				success:function(data){
					$("#point").html(data.point);
					
				}
			})
			getList();
		})
	});
	
	function getList(){
	$.ajax({
		type:"get",
		url:"/list/receive",
		dataType:"json",
		data:{"id":id},
		success:function(data){
			var temp = Handlebars.compile($("#rtemp").html());
			$("#rtbl").html(temp(data));

		}
	});
}
	
</script>
</html>