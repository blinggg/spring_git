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
	a{text-decoration:none;}
	a{color:green;}
	.active{color:red;}

</style>
<title>게시글목록</title>
</head>
<body>
	<h1>[게시글목록]</h1>
	   <a href="insert">입력</a>
	검색수:<span>${pm.totalCount}</span>
	<form name=frm action=list>
	
		<input type=text name=page value="${cri.page}">
		<input type=text name=bno>
		
		<select name="searchType">
   			<option value="title"<c:out value="${cri.searchType=='title'?'selected':''}"/>>제목</option>
   			<option value="writer" <c:out value="${cri.searchType=='writer'?'selected':''}"/>>작성자</option>
   			<option value="content" <c:out value="${cri.searchType=='content'?'selected':''}"/>>내용</option>
   		</select>
   		<input type=text name=keyword value="${cri.keyword}">
   		<input type=submit value=검색>
	</form>
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
   <div id=pagination>
	<c:if test="${pm.prev}">
		<a href="${pm.startPage-1}">◀</a>
	</c:if>
	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
		<c:if test="${cri.page==i}">
		<a href="${i}" class=active>[${i}]</a>
		</c:if>
		<c:if test="${cri.page!=i}">
		<a href="${i}">[${i}]</a>
		</c:if>
	</c:forEach>
	<c:if test="${pm.next}">
		<a href="${pm.endPage+1}">▶</a>
	</c:if>
   </div>
</body>
<script>
	$(frm).submit(function(){
		$(frm.page).val(1);
	});
	
	$(".row").on("click", function(){
		var bno=$(this).find(".bno").html();
		alert(bno);
		//location.href="read?bno="+bno;
		$(frm.bno).val(bno);
		frm.action="read";
		frm.submit();
		
	});
	
	$("#pagination").on("click", "a", function(e){
		e.preventDefault();
		var page=$(this).attr("href");
		$(frm.page).val(page);
		frm.submit();
		//alert(page);
	});

</script>
</html>