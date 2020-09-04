<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>[주소록]</title>
</head>
<body>
	<h1>[주소록]</h1>
	<table id=tbl>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" id="address"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" id="tel"></td>
			</tr>
		</table>
		<input type="button" value="입력" id="btnInsert">
		
		<table id="tbl1" border=1></table>
		<script id="temp1" type="text/x-handlebars-template">
			<tr class="title">
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
				<td>전화번호</td>
				<td>수정/삭제</td>
			</tr>

			{{#each list}}
			<tr class="row">
				<td class="id">{{id}}</td>
				<td><input class="name" type="text" value="{{name}}" size=5></td>
				<td><input class="address" type="text" value="{{address}}" size=20></td>
				<td><input class="tel" type="text" value="{{tel}}" size=20></td>
				<td>
					<button class="btnUpdate">수정</button>
					<button class="btnDelete">삭제</button>
				</td>
	
			</tr>		
			{{/each}} 
		</script>
</body>
<script>

	getList();
	
	function getList(){
		$.ajax({	
			type:"get",
			url:"/add/rest/list",
			dataType:"json",
			success:function(data){
				var temp = Handlebars.compile($("#temp1").html());
				$("#tbl1").html(temp(data));
			}
		});
	}
	
	$("#btnInsert").on("click", function(){
		if(!confirm("저장하시겠습니까?")) return;
		
		var name=$("#name").val();
		var address=$("#address").val();
		var tel=$("#tel").val();
		
		$.ajax({
			type:"post",
			url:"/add/rest/insert",
			data:JSON.stringify({"name":name,"address":address,"tel":tel}),
	        contentType:"application/json;charset=UTF-8",
			success:function(data){
				getList();	
			}
		});
	});
	
	$("#tbl1").on("click", ".row .btnUpdate", function(){
		if(!confirm("수정하시겠습니까?")) return;
		
		var row=$(this).parent().parent();
		var id=row.find(".id").html();
		var name=row.find(".name").val();
		var address=row.find(".address").val();
		var tel=row.find(".tel").val();
		
		//alert(name,address,tel);
		
		$.ajax({
			type:"post",
			url:"/add/rest/update",
			data:JSON.stringify({"id":id,"name":name,"address":address,"tel":tel}),
	        contentType:"application/json;charset=UTF-8",
			success:function(data){
				alert("수정되었습니다!");
				getList();	
			}
		});
	});
	
	$("#tbl1").on("click", ".row .btnDelete", function(){
		if(!confirm("삭제하시겠습니까?")) return;
		
		var row=$(this).parent().parent();
		var id=row.find(".id").html();
		//var name=row.find(".name").val();
		//var address=row.find(".address").val();
		//var tel=row.find(".tel").val();
		
		alert(id);
		
		$.ajax({
			type:"post",
			url:"/add/rest/delete",
			data:{"id":id},
			success:function(data){
				alert("삭제되었습니다!");
				getList();	
			}
		});
	});

</script>
</html>