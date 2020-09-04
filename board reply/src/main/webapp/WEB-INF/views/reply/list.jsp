<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply list</title>
<style>
.content {
	width: 500px;
	margin: 10px;
	padding: 10px;
	background: gray;
	color: White;
	border-radius: 5px;
}

.content .reply {
	font-weight: bold;
	padding: 0px 0px 0px 15px;
}
.content .replyDate {font-size:12px;}
#frm{margin: 0px 0px 0px 10px;}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>[ reply list ] :: ${pm.totalCount}건</h1>
	<div id="frm">
		<form name="frm" action="insert" method="post">
			<input type="hidden" name="bno" value="373">
			<input type="hidden" name="replyer" value="user01">
			<input type="text" name="reply" size=50 value="reply insert test">
			<input type="submit" value="저장">
		</form>
	</div>
	<c:forEach items="${list}" var="vo">
		<div class="content">
			<div class="replyDate">${vo.replyDate} :: <span class="rno">${vo.rno}</span>  
				<button>삭제</button>
			</div>
			<div class="reply">${vo.reply}
			</div>
		</div>
	</c:forEach>
	<ul class="pagination">
		<c:if test="${pm.prev}">
			<li class="page-item"><a class="page-link" href="${pm.startPage-1}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			<c:if test="${cri.page==i}">
				<li class="page-item active" aria-current="page"><a class="page-link" href="${i}">${i}</a></li>
			</c:if>
			<c:if test="${cri.page!=i}">
				<li class="page-item"><a class="page-link" href="${i}">${i}</a></li>
			</c:if>
		</c:forEach>
		<c:if test="${pm.next}">
			<li class="page-item"><a class="page-link" href="${pm.endPage+1}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
	</ul>
	
</body>
<script>
	$(".replyDate").on("click", "button", function() {
		var page="${cri.page}";
		var rno=$(this).parent().parent().find(".rno").html();
		if(!confirm(rno+"삭제하시겠습니까?")) return;
		location.href="delete?rno="+rno+"&page="+page;
	});

	$(".pagination").on("click", ".page-item .page-link", function(e) {
		e.preventDefault();
		var page = $(this).attr("href");
		location.href = "list?page=" + page;
	});
</script>
</html>