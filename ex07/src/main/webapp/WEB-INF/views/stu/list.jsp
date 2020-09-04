<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>학사관리</title>
</head>
<body>
		<h1>학생목록</h1>
		<table id=tbl border=1>
		<tr class=title>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학생학과</td>
			<td>수강목록</td>
		</tr>
		<c:forEach items="${list}" var="vo"> <!-- vo의 필드명과 같이 써줘야함 -->
			<tr class=row>
				<td class=scode>${vo.scode}</td>
				<td class=sname>${vo.sname}</td>
				<td class=dept>${vo.dept}</td>
				<td><button class=list>수강신청목록</button></td>
			</tr>
		</c:forEach>
	</table>
	<table id="etbl" border=1></table>
	<script id="etemp" type="text/x-handlebars-template">
			<tr class="title">
				<td>강좌번호</td>
				<td>강좌이름</td>
				<td>학생점수</td>
			</tr>
			{{#each array}}
			<tr class="row">
				<td>{{lcode}}</td>
				<td>{{lname}}</td>
				<td>{{grade}}</td>
			</tr>		
			{{/each}} 
		</script>
</body>
<script>
	
	$(".list").on("click", function(){
		var scode=$(this).parent().parent().find(".scode").html();
		alert(scode);
			$.ajax({	
				type:"get",
				url:"/stu/rest/elist",
				dataType:"json",
				data:{"scode":scode},
				success:function(data){
					var temp = Handlebars.compile($("#etemp").html());
					$("#etbl").html(temp(data));
				}
			});
		});
		
</script>
</html>