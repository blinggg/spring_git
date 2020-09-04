<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>[통장내역]</title>
<style>
#tbl, #stbl {
	border: 1px solid #BFB4AC;
	text-align: center;
	width: 500px;
	border-collapse: collapse;
}

.title {
	background: #F2BFAB;
}

.row:hover {
	background: #E7DBD3;
	color: white;
}

td {
	border: 1px solid #BFB4AC;
}

#stbl {
	border-top: 5px solid #BFB4AC;
	margin-top: 10px;
}
</style>
</head>
<script>
	
</script>
<body>
	<h1>[통장 내역]</h1>
	<table border=1 width=600>
		<tr>
			<td width=100 class="title">계좌번호</td>
			<td width=100 id="ano">${vo.ano}</td>
			<td width=100 class="title">성명</td>
			<td width=100 id="name">${vo.name}</td>
			<td width=100 class="title">잔액</td>
			<td width=100 id="balance">${vo.balance}</td>
		</tr>
	</table>

	<div
		style="border: 1px dotted; width: 580px; margin-top: 20px; padding: 10px; margin-bottom: 20px;">
		이체정보: <select style="height: 22px;" id="tradeNo">
			<c:forEach items="${list}" var="v">
				<c:if test="${v.ano != vo.ano}">
					<option value="${v.ano}">${v.ano}(${v.name})</option>
				</c:if>
			</c:forEach>
		</select> 
		<input type="text" id="amount"> 
		<input type="button" value="이체" id="btnInsert">
	</div>
	<table border=1 width=600 id="tbl"></table>
	<script id="temp" type="text/x-handlebars-template">
 	{{#each .}}
 		<tr {{{printStyle type}}}>
 			<td width=100>{{tradeNo}}</td>
 			<td width=100>{{name}}</td>
 			<td width=100>{{type}}</td>
 			<td width=100>{{amount}}원 </td>
 			<td width=200>{{tradeDate}}</td>
 		</tr>
 	{{/each}}
	</script>
	<div style="margin-top: 10px;">
		<button onClick="location.href='list'">통장목록</button>
	</div>
</body>
<script>
	/*Handlebars.registerHelper("printStyle", function(type){
		var src;
		if(type=="1") src="style=color:red;";
		return src;
	});*/
	
	getListTrade();
	
	function getListTrade() {
		$.ajax({
			type : "get",
			url : "/trade/list",
			data : {
				"ano" : ano
			},
			success : function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
			}
		});
	}
	
	$("#btnInsert").on("click", function(){
		//alert(".");
	if (!confirm("이체하시겠습니까?")) return;
		var ano = $("#ano").html();
		var tradeNo = $("#tradeNo").val();
		var amount = $("#amount").val();
		var type = "1";
		alert(ano+tradeNo+amount+type);
		$.ajax({
			type : "post",
			url : "/trade/insert",
			data : {
				"ano" : ano,
				"tradeNo" : tradeNo,
				"type" : type,
				"amount" : amount
			},
			
			success : function(data) {
				//alert(".");
				alert("이체완료!");
				$("#amount").val("");
			}
		})
	});
	
</script>
</html>