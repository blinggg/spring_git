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
	a{text-decoration:none;}
	.active{color:red;}
	#tbl,#stbl{border:1px solid black;}
</style>
<title>학생목록</title>
</head>
<body>
	<h1>학생목록</h1>
	<table id=stbl border=1>
		<tr class=title>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학생학과</td>
			<td>수강신청</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr class=row>
				<td class="scode">${vo.scode}</td>
				<td class="sname">${vo.sname}</td>
				<td class="dept">${vo.dept}</td>	
				<td><button class=erollInsert>수강신청</button>
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
    <div id="courses">
    	<span id="scode"></span>
    	<span id="sname"></span>
    	<select id="lcode">
    		<c:forEach items="${clist}" var="vo">
    			<option value="${vo.lcode}">${vo.lcode}:${vo.lname}</option>
    		</c:forEach>
    	</select>
    	<input type=button value="신청" id="btnInsert">
    </div>
    
    <table id=tbl></table>
    <script id="temp" type="text/x-handlebars-template">
		<tr>
			<td>강좌번호</td>
			<td>강좌이름</td>
			<td>수강신청일</td>
			<td>강좌점수</td>
			<td>수강취소</td>
		</tr>
		{{#each .}}
		<tr class=row>
			<td class="lcode">{{lcode}}</td>
			<td class="lname">{{lname}}</td>
			<td class="edate">{{edate}}</td>
			<td class="grade">{{grade}}</td>
			<td><button>수강취소</button></td>
		{{/each}}
	</script>	
</body>
<script>
	var scode, sname;
	$("#courses").hide();
	//getList();
	
	//수강취소 버튼을 눌렀을 때
	$("#tbl").on("click",".row button", function(){
		var lcode=$(this).parent().parent().find(".lcode").html();
		if(!confirm(scode+lcode+"수강취소하시겠습니까?")) return;
		
		$.ajax({
			type:"post",
			url:"/enroll/delete",
			data:{"scode":scode,"lcode":lcode},
			success:function(){
				alert("취소완료!");
				getList();	
			}
		});
	});
	
	//수강신청 버튼을 눌렀을 때
	$("#btnInsert").click(function(){
		var lcode=$("#lcode").val();
		if(!confirm(scode+lcode+" 을 신청하싈?")) return;
		
		$.ajax({
			type:"post",
			url:"/enroll/insert",
			dataType:"json",
			data:{"scode":scode,"lcode":lcode},
			success:function(count){
				if(count==0){
					alert("신청완료");
					getList();
				}else{
					alert("이미 신청된 강좌입니다.")
				}
			}
		});
	});
	
	//페이지 클릭이벤트
	$("#pagination a").click(function(e){
	    e.preventDefault(); //이동하지 못하게 방지하기!
	    var page=$(this).attr("href");
	    location.href="list?page="+page;
	 }); 
	
	$("#stbl").on("click", ".row button", function(){
		 $("#courses").show();
		//alert("~");
		var row=$(this).parent().parent();
		scode=row.find(".scode").html();
		sname=row.find(".sname").html();
		 //alert(scode,sname);
		 $("#scode").html(scode);
		 $("#sname").html(sname);

		 getList();
		
	});
	
	 function getList(){
		 $.ajax({
			type:"get",
			dataType:"json",
			url:"/stu/rest/elist",
			data:{"scode":scode},
			success:function(data){
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
	
			}
		 });
	 }

	 
</script>
</html>