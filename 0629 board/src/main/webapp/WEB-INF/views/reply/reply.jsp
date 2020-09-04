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
<title>댓글목록</title>
<style>
	#divInsert{background:gold;width:430px;height:40px;text-align:center;input}
	#btnInsert{float:right;padding-right:10px;}
	.tbl{border:1px solid gold;margin-top:10px;margin-bottom:20px;
	border-radius:5px;width:430px;}
	.delete{float:right;padding-right:10px;}
</style>
</head>
<body>
	<h1>댓글목록</h1>
	<div id="divInput">
		게시글수:<span id="count"></span>
	</div>
	<div id="divInsert">
		<input type="text" id="txtReply" size=50>
		<button id="btnInsert">✏️</button>
	</div>
	<div class="tbl"></div>
	<script id="temp" type="text/x-handlebars-template">
	{{#each list}}
		<div class="replydate">{{replydate}}<button class="delete" rno={{rno}}>🗑</button></div>
		<div class="reply">{{reply}}</div>
		<div class="replyer" style="border-bottom:1px solid gold;">{{replyer}}</div>
	{{/each}}
</script>
</body>
<script>
	var bno="${vo.bno}";
	//
	$(".tbl").on("click", ".replydate button", function(){
		var rno=$(this).attr("rno");
		if(!confirm(rno + "댓글을 삭제?")) return;	
		$.ajax({
			type:"post",
			url:"/reply/delete",
			data:{"rno":rno},
			success:function(){
				alert("삭제했습니다!");
				getList();
			}
		});
	});
	
	//Enter key를 눌렀을 때
	   $("#txtReply").keydown(function(key){
	      if(key.keyCode==13){
	        $("#btnInsert").click();
	      }
	   });

	$("#btnInsert").on("click", function(){
		var reply=$("#txtReply").val();
		if(reply==""){
			alert("댓글 내용을 입력하세요!");
			 return;
		}
		var replyer="user02";
		
		$.ajax({
			type:"post",
			url:"/reply/insert",
			data:{"bno":bno, "reply":reply, "replyer":replyer},
			success:function(){
				alert("입력했습니다!");
				$("#txtReply").val("");
				getList();
			}
		});
		
	});
	
	getList();
	
	function getList(){
		$.ajax({
			type:"get",
			url:"/costumeReply",
			data:{"bno":bno},
			dataType:"json",
			success:function(data){
				//alert(bno);
				var temp = Handlebars.compile($("#temp").html());
				$(".tbl").html(temp(data));
				$("#count").html(data.count);
			}
		});
	}
	
</script>
</html>