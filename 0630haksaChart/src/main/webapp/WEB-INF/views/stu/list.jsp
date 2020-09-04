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
	a{text-decoration:none;}
	.active{color:red;}
	#tbl,#stbl{border:1px solid black;}
</style>
<title>학생목록</title>
</head>
<body>
	<h1>학생목록</h1>
		[학생목록: <span>${pm.totalCount}</span>건]
	<table id=stbl border=1>
		<tr class=title>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학생학과</td>
			<td>지도교수</td>
			<td>지도교수명</td>
			<td>생년월일</td>
			<td>학생정보보기</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class=row>
				<td class="scode">${vo.scode}</td>
				<td class="sname">${vo.sname}</td>
				<td class="dept">${vo.dept}</td>
				<td class="advisor">${vo.advisor}</td>
				<td class="pname">${vo.pname}</td>
				<td>${vo.birthday}</td>
				<td><button>정보보기</button></td>
			</tr>		
		</c:forEach>
	</table>
	   <div id="pagination">
        <c:if test="${pm.prev}">
            <a href="${pm.startPage-1}">◀</a>
        </c:if>
        <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
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
	//페이지 클릭이벤트
	$("#pagination a").click(function(e){
	    e.preventDefault(); //이동하지 못하게 방지하기!
	    var page=$(this).attr("href");
	    location.href="list?page="+page;
	 }); 
	
	$("#stbl").on("click", ".row", function(){
		var scode=$(this).find(".scode").html();
		var page=$("#pagination .active").html();
		location.href="read?scode="+scode+"&page="+page;
	});
</script>
</html>