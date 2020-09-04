<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>[강좌목록]</title>
<style>
	#ctbl,#stbl{width:500px;text-align:center;}
</style>
</head>
<body>
	<h1>강좌목록</h1>
	<table id=ctbl border=1 style="margin-bottom:10px;">
		<tr class=title>
			<td>강좌번호</td>
			<td>강좌이름</td>
			<td>지도교수</td>
			<td>수강학생</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class=row>
				<td class="lcode">${vo.lcode}</td>
				<td class="lname">${vo.lname}</td>
				<td class="">${vo.instructor}:${vo.pname}</td>	
				<td><button>수강학생</button>
			</tr>		
		</c:forEach>
			</table>
	<div id="courses">
		<span id="lcode"></span>
    	<span id="lname"></span>
	</div>
		<h1>특정강좌를 신청한 학생 목록</h1>
	    <table id=stbl border=1></table>
    <script id="stemp" type="text/x-handlebars-template">
		<tr class=title>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>수강신청일</td>
			<td>강좌점수</td>
			<td>점수수정</td>
		</tr>
		{{#each .}}
		<tr class=row>
			<td class="scode">{{scode}}</td>
			<td class="sname">{{sname}}</td>
			<td class="edate">{{edate}}</td>
			<td><input type="text" value="{{grade}}" size=5 class="grade" oldGrade="{{grade}}"></td>
			<td><button>점수수정</button></td>
		{{/each}}
	</script>	
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
	var lcode, lname;
	
	//점수수정 버튼을 눌렀을 때
	$("#stbl").on("click", ".row button", function(){
		var row=$(this).parent().parent();
		var scode=row.find(".scode").html();
		var grade=row.find(".grade").val();
		var oldGrade=row.find(".grade").attr("oldGrade");
		//lcode=$("#lcode").val();
		//alert(scode+grade+lcode);
		alert(oldGrade+"점을"+grade+"점으로 수정하시겠습니까?");
		
		if(grade<0 || grade>100){
			alert("점수를 다시 입력하세요!");
			getList();
		}else{
		 	$.ajax({
				type:"post",
				url:"/enroll/update",
				data:{"lcode":lcode,"scode":scode,"grade":grade},
				success:function(){}
			 	});
				alert("수정이 완료되었습니다!");
			}
		});
	
	//페이지 클릭이벤트
	$("#pagination a").click(function(e){
	    e.preventDefault(); //이동하지 못하게 방지하기!
	    var page=$(this).attr("href");
	    location.href="list?page="+page;
	 }); 
	
	//수강학생 버튼을 클릭했을 때
	$("#ctbl").on("click", ".row button", function(){
		var row=$(this).parent().parent();
		lcode=row.find(".lcode").html();
		lname=row.find(".lname").html();
		//alert(lcode+lname);
		$("#lcode").html(lcode);
		$("#lname").html(lname);
		getList();
	});
	
		//alert(lcode);
		function getList(){
		 $.ajax({
			type:"get",
			dataType:"json",
			url:"/cou/rest/slist",
			data:{"lcode":lcode},
			success:function(data){
				var temp = Handlebars.compile($("#stemp").html());
				$("#stbl").html(temp(data));
	
				}
		 	});
	 	}
</script>
</html>