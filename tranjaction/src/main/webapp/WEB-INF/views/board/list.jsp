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
	<style>
		.row:hover{background:gray; color:white;}
		.row{cursor:pointer;}
		a{color:black; text-decoration:none;}
		.active{color:red;}
	</style>
<title>게시판목록</title>
</head>
<body>
	<h1>게시판목록</h1>
	<form name=frm action=read>
		<input type="text" name="page" value="${cri.page}">	
		<input type="text" name="bno">
	</form>

	[게시글 수: <span>${pm.totalCount}</span>건]
	  <table border=1>
      <tr class=title>
         <th>글번호</th>
         <th>글제목</th>
         <th>작성자</th>
         <th>글내용</th>
         <th>작성일</th>
         <th>수정일</th>
         <th>View</th>
      </tr>
      <c:forEach items="${list}" var="vo">
      <tr class=row>
         <td class=bno>${vo.bno}</td>
         <td>${vo.title}[${vo.replycnt}]</td>
         <td>${vo.writer}</td>
         <td>${vo.content}</td>
         <td>${vo.regdate}</td>
         <td><fmt:formatDate value="${vo.updatedate}" pattern="yyyy-mm-dd hh:mm:ss"/></td>
         <td>${vo.viewcnt}</td>
      </tr>
      </c:forEach>
   </table>
   <div id="pagination">
        <c:if test="${pm.prev}">
            <a href="${pm.startPage-1}">◀</a>
        </c:if>
        <c:forEach begin="${pm.startPage}"  end="${pm.endPage}" var="i">
            <c:if test="${pm.cri.page == i }">
                [<a href="${i}" class='active'>${i}</a>]
            </c:if>
            <c:if test="${pm.cri.page != i }">
                [<a href="${i}">${i}</a>]
            </c:if>
        </c:forEach>
        <c:if test="${pm.next}">
            <a href="${pm.endPage+1}">▶</a>
        </c:if>
    </div>
</body>
<script>
	$("#pagination a").on("click",function(e) {
		e.preventDefault();
		var page=$(this).attr("href");
		location.href="list?page="+page;
	});
	
	$(".row").on("click", function() {
		var bno=$(this).find(".bno").html();
		$(frm.bno).val(bno);
		frm.submit();
	});
		
</script>
</html>