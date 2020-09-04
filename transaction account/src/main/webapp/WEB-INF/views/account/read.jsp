<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<style>
	#tbl,#atbl{border:1px solid #BFB4AC;text-align:center;width:500px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	
</style>
	<title>통장 내역</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<h1>[통장내역]</h1>
	<table id="atbl">
		<tr>
			<td class=title>계좌번호</td>
			<td id="ano" width=100>${read.ano}</td>
			
			<td class=title>성명</td>
			<td id="name" width=100>${read.name}</td>
			
			<td class=title>잔액</td>
			<td id="balance" width=100>
				<input type="hidden" value="${read.balance}">${read.balance}
			</td>
		</tr>
	</table>
	<br>
	<hr>
	
	<div>
		이체계좌번호:
		<select id="tradeNo"> 
		<c:forEach items="${list}" var="v">
			<c:if test="${read.ano!=v.ano}">
				<option value="${v.ano}">${v.ano}(${v.name})</option>
			</c:if>
		</c:forEach>
		</select>
		<input type="text" id="amount">
		<button type="button" id="btnInsert" value="이체">이체</button>
		<button id="btnList">목록</button>
		<table id="tbl" border=1></table>
		<script id="temp" type="text/x-handlebars-template">
				<tr>
					<td width=100>계좌번호</td>
					<td width=100>입금/출금</td>
					<td width=100>거래금액</td>
					<td width=200>거래일</td>
				</tr>
			{{#each .}}
				<tr {{printStyle type}}>
					<td>{{tradeNo}}</td>
					<td>{{printType type}}</td>
					<td>{{amount}}</td>
					<td>{{tradeDate}}</td>
				</tr>
			{{/each}}
		</script>
	</div>
</body>
<script>
	Handlebars.registerHelper("printStyle",function(type){
		var src;
		if(type=="1") src="style=color:red;";
		return src;
	});
	
	Handlebars.registerHelper("printType",function(type){
		var src;
		if(type=="1") src="출금";
		else src="입금";
		return src;
	});
	
	var ano=$("#ano").html();
	
	getList();

	function getList(){
		$.ajax({
			type:"get",
			url:"/trade/list",
			dataType:"json",
			data:{"ano":ano},
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
				 $("#tbl").html(temp(data));
			}
		})
	}
	
	$("#btnList").on("click", function(){
		location.href="list";
	});
	
	$("#btnInsert").on("click",function(){
			//alert("화이팅");
			ano=$("#ano").html();
			var tradeNo=$("#tradeNo").val();
			var amount=$("#amount").val();
			var balance=parseInt("${read.balance}");
			var type="1";
			alert(ano+tradeNo+amount+balance+type);
			
			if(amount > balance){
				alert(amount+"계좌잔액이 부족합니다!"+balance);
			}else{
			
			$.ajax({
				type:"post",
				url:"/trade/insert",
				data:{"ano":ano,"tradeNo":tradeNo,"amount":amount,"type":type},
				success:function(){
					alert("이체되었습니다.");
					$.ajax({
						type:"get",
						url:"/account/getBalance",
						dataType:"json",
						data:{"ano":ano},
						success:function(data){
							$("#balance").html(data.balance);
							location.href="read?ano="+ano;
							}
						})
				
					}
				})
			}
			
	});
	
</script>
</html>