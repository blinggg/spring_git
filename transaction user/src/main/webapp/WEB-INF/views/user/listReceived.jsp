<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받은 메시지 목록</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
	#tbl,#rtbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	#divR{background:#F2BFAB;color:white;padding:10px;width:480px;}
</style>
</head>
<body>
	<h1>[받은메시지]</h1>
	<div style="margin-bottom:10px;">
		<table id="rtbl" border=1>
			<tr>
				<td>받은이:<span id="name">${vo.name}</span></td>
				<td>포인트:<span id="point">${vo.point}</span>점
				</td>
			</tr>
		</table>
	<table id="tbl" border=1 width=500></table>
 	<script id="temp" type="text/x-handlebars-template">
		<tr class="title">
			<td>no</td>
			<td>sender</td>
			<td>message</td>
			<td>view</td>
		</tr>
 		{{#each .}}
 			<tr class=row {{printStyle readDate}}>
 				<td class="mid" width=20>{{mid}}</td>
 				<td style="font-size:8pt;"><b>{{name}}-{{receiver}}</b></td>
 				<td>{{message}}</td>
				<td><button>👀</button></td>
 			</tr>
 		{{/each}}
 	</script>
	</div>
	<div id="divR">
		Sender:<span id="sender"></span><br>
		Message:<span id="message"></span><br>
		Send Date:<span id="sendDate"></span><br>
		Read Date:<span id="readDate"></span><br>
	</div>
</body>
<script>
	Handlebars.registerHelper("printStyle", function(readDate){
		var src;
		if(readDate==null) src="style=color:red;";
		return src;
	});
	
	var id="${vo.id}";
	
	getList();
	
	$("#divR").hide();
	
	$("#divMessage").hide();
	
	$("#tbl").on("click", ".row button", function(){
		var mid=$(this).parent().parent().find(".mid").html();
		$.ajax({
			type:"get",
			url:"/message/read",
			data:{"mid":mid},
			dataType:"json",
			success:function(data){
				$("#sender").html(data.sender + ":" + data.name);
				$("#message").html(data.message);
				$("#sendDate").html(data.sendDate);
				$("#readDate").html(data.readDate);
				$("#divR").show();

				$.ajax({
					type:"get",
					url:"/user/getUser",
					data:{"id":id},
					dataType:"json",
					success:function(data){
						$("#point").html(data.point);
					}
				})
				getList();
			}
		})
	});
	
	function getList() {
		id = "${vo.id}"
		
		$.ajax({
			type : "get",
			url : "/list/received",
			data : {
				"id" : id
			},
			dataType : "json",
			success : function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
			}
		});
	}
</script>
</html>