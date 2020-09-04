<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<style>
.box {
	width: 100px;
	height: 150px;
	padding: 5px;
	margin: 5px;
	background: #BBD4E5;
	color: white;
	float: left;
	font-size: 15px;
}

a {
	color: black;
}

#search{width:480px;background: #BBD4E5;margin-bottom:10px;text-align:center;}

</style>
<title>[상품목록]</title>
</head>
<body>
	<h1>상품목록</h1>
	총 상품건수:<span>${pm.totalCount}</span>
	<div id="search">
		<form name="frm" action="list">
			<select name="searchType">
				<option value="pcode" <c:out value="${cri.searchType=='pcode'?'selected':''}"/>>상품코드</option>
				<option value="pname" <c:out value="${cri.searchType=='pname'?'selected':''}"/>>상품이름</option>
			</select>
			<input type="text" name="keyword" value="${cri.keyword}">
			<input type="submit" value="검색">
		</form>
	</div>
	<div style="width: 480px; background: #CFF0F8; overflow: hidden;">
		<c:forEach items="${list}" var="vo">
			<div class="box">
				<c:if test="${vo.image!=null && vo.image!=''}">
					<img id="image" src="/display?fileName=${vo.image}" width=100>
				</c:if>
				<c:if test="${vo.image==null || vo.image==''}">
					<img id="image" src="http://placehold.it/100x80" width=100>
				</c:if>
				<div>
					<a href="read?pcode=${vo.pcode}">${vo.pcode}</a>
				</div>
				<div>${vo.pname}</div>
				<div>${vo.price}원</div>
			</div>
		</c:forEach>
	</div>
	<button onclick="location.href='insert'">상품등록</button>
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
</script>
</html>