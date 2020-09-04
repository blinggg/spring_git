<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸메시지</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<style>
	#SenderRead,#DeleteList,#SendList{width:500px;border-collapse:collapse;border:1px solid #BFB4AC;text-align:center;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	#button{background:#F2BFAB;width:480px;height:30px;
	margin-top:10px;margin-bottom:10px;text-align:center;padding:10px;}
</style>
<body>
	<h1>[보낸메시지]</h1>
	<table id="SenderRead">
		<tr>
			<td class="title" width=100>보낸이:</td>
			<td><span id=name>${vo.name}</span>&nbsp;포인트:${vo.point}<span id="point"></span>점</td>
		</tr>
		<tr>
			<td class="title" width=100>받는이:</td>
			<td width=100><select id="receiver">
					<c:forEach items="${list}" var="vo">
						<c:if test="${vo.id!=param.id}">
							<option value="${vo.id}">${vo.id} - ${vo.name}</option>
						</c:if>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="title">내용:</td>
			<td><input type="text" size=50 id="message"></td>
		</tr>
	</table>
	<div id="button">
		<input type="button" value=✍ id="btnSend">
		<input type="button" value=🗑 id="btnList">
		<input type="button" value=📄 id="UserList" OnClick="location.href='list'">
	</div>
	<table id="SendList" border=1 width=500></table>	
 	<script id="temp" type="text/x-handlebars-template">
		<tr class="title">
			<td>no</td>
			<td>receiver</td>
			<td>message</td>
			<td>delete</td>
		</tr>
 		{{#each .}}
 			<tr class=row>
 				<td class="mid">{{mid}}</td>
 				<td style="font-size:8pt;"><b>{{name}}-{{receiver}}</b></td>
 				<td>{{message}} {{{printStyle readDate}}}</td>
				<td><button class="btnDelete">🗑</button></td>
 			</tr>
 		{{/each}}
 	</script>
 	<h1>[휴지통]</h1>
 	<table id="DeleteList" border=1 width=500></table>	
 	<script id="dtemp" type="text/x-handlebars-template">
		<tr class="title">
			<td>no</td>
			<td>receiver</td>
			<td>message</td>
			<td>delete</td>
			<td>Restore</td>
		</tr>
 		{{#each .}}
 			<tr class=row>
 				<td class="mid">{{mid}}</td>
 				<td style="font-size:8pt;"><b>{{name}}-{{receiver}}</b></td>
 				<td>{{message}} {{{printStyle readDate}}}</td>
				<td><button class="btnDelete">❌</button></td>
				<td><button class="restore">◀</button></td>
 			</tr>
 		{{/each}}
 	</script>
</body>
<script>
	Handlebars.registerHelper("printStyle", function(readDate){
		var src;
		//if(readDate==null) src="style=color:red;";
		if(readDate==null) src="<b>[읽지않음]</b>";
		return src;
	});
	
	var id;
	var mid;
	getList();
	
	//삭제복원버튼을 눌렀을 때
	$("#DeleteList").on("click", ".restore", function(){
		mid=$(this).parent().parent().find(".mid").html();
		//alert(mid);
		getRestore();
		DeleteList();
	});
	
		//삭제복원하는 함수
		function getRestore(){
		$.ajax({
			type:"get",
			url:"/list/RestoreSdel",
			data:{"mid":mid},
			success:function(){
				getList();
				alert("보낸메시지함으로 복원합니다.");
				DeleteList();
				}
			})
		}
	
	//휴지통보이기
	$("#btnList").on("click", function(){
		id="${vo.id}";
		//alert(id);
		DeleteList();
	});
		
		//삭제된 목록 보이기
		function DeleteList(){
		$.ajax({
			type:"get",
			url:"/list/delete",
			data:{"id":id},
			success:function(data){
				var temp=Handlebars.compile($("#dtemp").html());
	            $("#DeleteList").html(temp(data));
				}
			})
		}
	
	//메시지 삭제하기
	$("#SendList").on("click", ".btnDelete", function(){
		//alert(".");
		var row=$(this).parent().parent();
		mid=row.find(".mid").html();
		$.ajax({
			type:"get",
			url:"/message/sdelete",
			data:{"mid":mid},
			success:function(){
				alert("삭제되었습니다!");
				getList();
				DeleteList();
			}
		})
	});
	
	//메시지 보내기 버튼을 눌렀을 때
	$("#btnSend").on("click", function(){
		var sender=id;
		var receiver=$("#receiver").val();
		var message=$("#message").val();
		if(message==""){
			alert("메세지를 입력하세요");
			$("#message").focus();
			return;
		}
		
		$.ajax({
			type:"post",
			url:"/message/insert",
			data:{"sender":sender,"receiver":receiver,"message":message},
			success:function(){
				alert("전송완료");
				$("#message").val("");
				getList();
			}
		})
	})
	
	//보낸 목록 출력하기
	function getList(){
		id="${vo.id}"
		$.ajax({
			type:"get",
			url:"/list/send",
			data:{"id":id},
			dataType:"json",
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
	            $("#SendList").html(temp(data));
			}
		});
	}
	
</script>
</html>