<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
 #tbl {width:960px;border:1px solid black;overflow:hidden; }
</style>
<meta charset="UTF-8">
<title>[에어비엔비 크롤링하기]</title>
</head>
<body>
	<h1>[숙박정보:서울]</h1>
	<button id="btnInsert">저장</button>
	<table id="tbl"></table>
	<script id="temp" type="text/x-handlebars-template">

	{{#each array}}
	<tr class="row">
		<td><input class="chk" type="checkbox"></td>
		<td class="title">{{title}}</td>
		<td><img src="{{image}}" width=100></td>
		<td class="info">{{info}}</td>
		<td class="rating">{{rating}}</td>
	</tr>
	{{/each}}
	</script>
</body>
<script>
	$("#btnInsert").on("click", function(){
		if(!confirm("저장하싈?")) return;
		$("#tbl .row .chk:checked").each(function(){
			var row=$(this).parent().parent();
			var title=row.find(".title").text(); //태그값 제외하고 출력할 때
			var info=row.find(".info").text();
			var rating=row.find(".rating").text();
			var image=row.find("img").attr("src");
			
			//alert(title+info+rating+image);
			
			$.ajax({
				type:"get",
				url:"/insert",
				data:{"title":title, "info":info, "rating":rating, "image":image},
				success:function(){}
				});
			
				$(this).prop("checked", false);
			});
			alert("저장완료!");
		});
	
	getAirbnb();
	function getAirbnb(){ 
		$.ajax({
		type:"get", 
		url:"/airbnb.json",
		dataType:"json",
		success:function(data) {
			var temp=Handlebars.compile($("#temp").html());
			$("#tbl").html(temp(data));
			}
		});
	}

</script>
</html>