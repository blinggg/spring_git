<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>students list</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<style>
		.title{ background: #87CEFA; color: #EBFBFF;}
		a{text-decoration: none; color:black;}
		.active{color:red;}
		.row:hover { background:#CDECFA; }
	</style>
</head>
<body>
	<h1> [ STUDNETS LIST ]</h1>
	총 학생 수: ${pm.totalCount}
	<table id="stbl" border=1>
		<tr class="title">
			<th width=100>CODE</th>
			<th width=70>NAME</th>
			<th width=50>DEPT</th>
			<th width=50>year</th>
			<th width=100>BIRTHDAY</th>
			<th width=90>ADVISOR</th>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr class="row">
			<td class="scode">${vo.scode}</td>
			<td class="sname">${vo.sname}</td>
			<td class="dept">${vo.dept}</td>
			<td class="year">${vo.year}</td>
			<td class="birthday">${vo.birthday}</td>
			<td class="advisor">${vo.pname}(${vo.advisor})</td>
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
	$("#stbl").on("click",".row", function() {
		var scode=$(this).find(".scode").html();
		var page=$("#pagination .active").html();
		location.href="read?scode="+scode+"&page="+page;
	});

	$("#pagination a").click(function(e){
	    e.preventDefault();
	    var page=$(this).attr("href");
	    location.href="list?page="+page;
	 });
</script>
</html>