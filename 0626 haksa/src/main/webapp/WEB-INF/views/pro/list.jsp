<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>교수목록</title>
</head>
<body>
		<h1>교수목록</h1>
	<table id=ptbl border=1>
		<tr class=title>
			<td>교수번호</td>
			<td>교수이름</td>
			<td>담당학과</td>
			<td>직급</td>
			<td>학생보기</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class=row>
				<td class="pcode">${vo.pcode}</td>
				<td class="pname">${vo.pname}</td>
				<td class="dept">${vo.dept}</td>
				<td class="title">${vo.title}</td>
				<td><button>학생보기</button>
			</tr>		
		</c:forEach>
	</table>
    <table id="tbl" border=1></table>
    <script id="temp" type="text/x-handlebars-template">
		<tr>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학생학과</td>
		</tr>
		{{#each slist}}
		<tr class=row>
			<td class="scode">{{scode}}</td>
			<td class="sname">{{sname}}</td>
			<td class="dept">{{dept}}</td>
		{{/each}}
		<tr>
			<td>강좌번호</td>
			<td>강좌이름</td>
			<td>강의실</td>
		</tr>
		<br><br>
		{{#each clist}}
		<tr class=row>
			<td class="lcode">{{lcode}}</td>
			<td class="lname">{{lname}}</td>
			<td class="room">{{room}}</td>
		{{/each}}
	</script>	
</body>
<script>
	var pcode;
	
	$("#ptbl").on("click", ".row button",function(){
		//alert("..");
		pcode=$(this).parent().parent().find(".pcode").html();
		alert(pcode);
		getList();
	});
		
		function getList(){
		 $.ajax({
			type:"get",
			dataType:"json",
			url:"/pro/plist",
			data:{"pcode":pcode},
			success:function(data){
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
	
			}
		});
	}
	
	
	
</script>
</html>