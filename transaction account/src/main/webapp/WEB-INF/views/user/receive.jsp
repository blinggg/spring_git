 	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<style>
	#tbl,#rtbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	
</style>

	<title>Receive Message</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<h1>[Receive Message]</h1>
	<table id="rtbl">
		<tr>
			<td width=200>receiver :${read.name}</td>
			<td>
			${read.name}&nbsp;&nbsp; 포인트 :
			<span id="point">${read.point}</span>
			</td>
		</tr>
		
	</table>
	
	
	<table id="tbl" border=1></table>
	<script id="temp" type="text/x-handlebars-template">
			<tr>
				<td width=150>mid</td>
				<td width=150>receiver</td>
				<td width=220>message</td>
				<td>view</td>
			</tr>
		{{#each .}}
			<tr class="row" {{printStyle readDate}}>
				<td class="mid">{{mid}}</td>
				<td>{{receiver}}:{{name}}</td>
				<td>{{message}}<button class="btnRdel">삭제</button></td>
				<td><button>View</button></td>
			</tr>
		{{/each}}
	</script>
	<div id="divMessage" style="width:480px;background:gray;color:white;padding:10px;margin-top:10px;">
		 보낸이: <span id="sender"></span><br>
 		내용: <span id="message"></span><br>
		 발신일: <span id="sendDate"></span><br>
 		수신일: <span id="readDate"></span><br>
	 </div>
</body>
<script>

	Handlebars.registerHelper("printStyle",function(readDate){
		var src;
		if(readDate==null) src="style=color:red;";
		return src;
	});
	
	
	var id="${read.id}";
	$("#divMessage").hide();
	getList();

	$("#tbl").on("click",".row .btnRdel",function(){
		var row=$(this).parent().parent();
		var mid=row.find(".mid").html();
		
		$.ajax({
			type:"get",
			url:"/message/rdelete",
			data:{"mid":mid},
			success:function(){
				alert("삭제 완료");
				getList();
				$("#divMessage").hide();
			}
		});
	});

	function getList(){	
		$.ajax({
			type:"get",
			url:"/list/receive",
			data:{"id":id},
			dataType:"json",
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				 $("#tbl").html(temp(data));
			}
		});
	}

	
	$("#tbl").on("click",".row button",function(){
		var row= $(this).parent().parent();
		var mid=row.find(".mid").html();
		$.ajax({
			type:"get",
			url:"/message/read.json",
			data:{"mid":mid},
			dataType:"json",
			success:function(data){
				$("#sender").html(data.sender+" : "+ data.name);
				$("#message").html(data.message);
				$("#sendDate").html(data.sendDate);
				$("#readDate").html(data.readDate);
				$("#divMessage").show();
				
				
				$.ajax({
					type:"get",
					url:"/user/getUser",
					data:{"id":id},
					dataType:"json",
					success:function(data){
						$("#point").html(data.point);
					}
				});
			}
		});
		getList();
	});
</script>
</html>