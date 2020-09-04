<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
	.row:hover{background:gray;color:white;}
	.row{cursor:pointer;}

</style>
<title>게시글목록</title>
</head>
<body>
	<h1>[게시글목록]</h1>
   <a href="insert">입력</a>
   <table border=1>
      <tr class=title>
         <th>글번호</th>
         <th>글제목</th>
         <th>작성자</th>
         <th>글내용</th>
         <th>작성일</th>
         <th>수정일</th>
      </tr>
      <c:forEach items="${list}" var="vo">
      <tr class=row>
         <td class=bno>${vo.bno}</td>
         <td>${vo.title}</td>
         <td>${vo.writer}</td>
         <td>${vo.content}</td>
         <td>${vo.regdate}</td>
         <td>${vo.updatedate}</td>
      </tr>
      </c:forEach>
   </table>
</body>
<script>
	$(".row").on("click", function(){
		var bno=$(this).find(".bno").html();
		//alert(bno);
		location.href="read?bno="+bno;
	});


</script>
</html>