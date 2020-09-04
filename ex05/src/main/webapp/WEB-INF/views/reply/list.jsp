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
#divReply {
	width: 490px;
	border: 1px solid gray;
	padding: 5px;
}

.header {
	background: gray;
	color: white;
	padding: 10px;
}

.replyDate {
	float: right;
	font-size: 12px;
}

#pagination{text-align:center;}
a{color:black; text-decoration:none; }
.active{color:red;}
</style>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

</head>
<body>
	<div id="divReply">
		<div class="header">
			[ reply list ] :: [<span id="total"></span>] <span style="float: right"><button
					id="btnReplyOpen">댓글쓰기</button></span>
		</div>
		<div id="replies"></div>
		<script id="temp" type="text/x-handlebars-template">
 		{{#each array}}
 			<div rno="{{rno}}">
 				<span class="replyer">{{replyer}}</span>
				<span class="replyDate">{{replyDate}}</span>
 				<div class="reply">{{reply}}</div>
				<div><button class="btnUpdate">수정</button></div>
 				<hr style="border:0.5px dotted gray;">
 			</div>
 		{{/each}}
 	</script>
		<div id="pagination"></div>
	</div>
</body>
<script>
	var page = 1;
	var bno="${vo.bno}";
	getList();

	function getList() {
		$.ajax({
			type : "get",
			url : "/reply/list.json",
			data:{"page":page,"bno":bno},
			success : function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#replies").html(temp(data));
				//페이지 리스트 출력
				var str = "";
				if (data.pm.prev) {
					str += "<a href='" + (data.pm.startPage - 1) + "'>◀</a>"
				}
				for (var i = data.pm.startPage; i <= data.pm.endPage; i++) {
					if (page == i) {
						str += "[<a href='" + i + "' class='active'><b>" + i + "</b></a>]";
					} else {
						str += "[<a href='" + i + "'>" + i + "</a>]";
					}
				}
				if (data.pm.next) {
					str += "<a href='" + (data.pm.endPage + 1) + "'>▶</a>"
				}
				$("#pagination").html(str);
				//전체 데이타 출력
				$("#total").html(data.pm.totalCount);
			}
		});
	}
	
	$("#pagination").on("click","a", function(e) {
		e.preventDefault();
		page=$(this).attr("href");
		getList();
	});
</script>
</html>