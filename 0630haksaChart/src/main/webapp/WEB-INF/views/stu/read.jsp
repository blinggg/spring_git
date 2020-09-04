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
<script>
var scode="${vo.scode}";
</script>
<title>학생정보보기</title>
<style>
	#cou{margin-top:10px;}
</style>
</head>
<body>
		<form name="frm" action="update" method="post">
		<table class="stbl" border=1 width=500>
			<tr>
				<td>페이지</td>
				<td><input type="text" name="page" value="${page}"></td>
			</tr>
			<tr>
				<td width=100>학생코드</td>
				<td><input type="text" name="scode" size=20 value="${vo.scode}" readonly></td>
			</tr>
			<tr>
				<td width=100>학생이름</td>
				<td><input type="text" name="sname" size=20 value="${vo.sname}"></td>
			</tr>
			<tr>
				<td>학생학과</td>
				<td>
 				<select name="dept">
 					<option <c:out value="${vo.dept=='전산'?'selected':''}"/>>전산</option>
 					<option <c:out value="${vo.dept=='전자'?'selected':''}"/>>전자</option>
 					<option <c:out value="${vo.dept=='건축'?'selected':''}"/>>건축</option>
				</select>
				
 				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birthday" size=20 value="${vo.birthday}"></td>
			</tr>
			<tr>
			<td width=100>지도교수</td>
			<td>
 				<select name="advisor">
 					<option value="${vo.advisor}">${vo.advisor}</option>
				</select>				
 			</td>
 			</tr>
			<tr>
			<td width=100>지도교수명</td>
			<td>		
 				<select name="pname">
 				<c:forEach items="${plist}" var="vo">
 					<option value="${vo.pcode}">${vo.pname}</option>
 					</c:forEach>
				</select>		
 			</td>
 			</tr> 
		</table>
		<input type="submit" value="수정"> 
		<input type="reset" value="취소"> 
		<input type="button" value="삭제" id="btnDelete">
		<input type="button" value="목록" id="btnList">
	</form>
	<div id=cou>
		<select id="lcode">
			<c:forEach items="${clist}" var="vo">
				<option value="${vo.lcode}">${vo.lname}-${vo.pname}</option>
			</c:forEach>
		</select>
		<input type="button" value="수강신청" id="btnInsert">
	</div>
	<table id=etbl border=1></table>
    <script id="etemp" type="text/x-handlebars-template">
		<tr>
			<td>강좌번호</td>
			<td>강좌이름</td>
			<td>수강신청일</td>
			<td>강좌점수</td>
		</tr>
		{{#each list}}
		<tr class=row>
			<td class="lcode">{{lcode}}</td>
			<td class="lname">{{lname}}</td>
			<td class="edate">{{edate}}</td>
			<td>
				<input type="text" value="{{grade}}" class="grade" oldGrade="{{grade}}">
				<input type="button" value="수정" class="btnUpdate">
				<input type="button" value="삭제" class="btnDelete">
			</td>
		{{/each}}
	</script>
	<div id="chart">
		<jsp:include page="chart.jsp"/>
	</div>	
</body>
<script>
	var page="${page}";

	getList();
	
	//수강신청 버튼을 눌렀을 때
	$("#btnInsert").click(function(){
		var lcode=$("#lcode").val();
		if(!confirm(scode+lcode+" 을 신청하싈?")) return;

		$.ajax({
			type:"post",
			url:"/enroll/insert",
			dataType:"json",
			data:{"scode":scode,"lcode":lcode},
			success:function(){
				alert("수강신청이 되었습니다!");
			}
		});
		getList();
	});	

	//수강취소 버튼을 눌렀을 때
	$("#etbl").on("click",".btnDelete", function(){
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
	
	//점수수정 버튼을 눌렀을 때
	$("#etbl").on("click", ".btnUpdate", function(){
		var row=$(this).parent().parent();
		var lcode=row.find(".lcode").html();
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
			    changeChart();
			}
		});
	
	//수강신청한 내역 보기
	 function getList(){
		 $.ajax({
			type:"get",
			dataType:"json",
			url:"/stu/listEnroll",
			data:{"scode":scode},
			success:function(data){
				//alert(scode);
				var temp = Handlebars.compile($("#etemp").html());
				$("#etbl").html(temp(data));
	
				}
		 });
	 }
	
	//목록이동하기
	$("#btnList").on("click", function(){
		location.href="list?page="+page;	
	});
	
	//
	$(frm.pname).change(function(){
		var pcode=$(frm.pname).val();
		$(frm.advisor).val(pcode);
	});
	
	//수정버튼을 눌렀을 때
	$(frm).submit(function(e){
		e.preventDefault();
		if(!confirm("수정하실?")) return;
		frm.submit();
	});
	
	//학생삭제버튼을 눌렀을 때
	$("#btnDelete").on("click", function(){
		if(!confirm("삭제하실?")) return;
		//alert(scode);
		$.ajax({
			type:"post",
			url:"/enrollCount",
			data:{"scode":scode},
			dataType:"json",
			success:function(count){
				alert(scode);
				if(count==0){
					alert("삭제되었습니다.");
					frm.action="delete";
					frm.submit();
				}else{
					alert("수강신청내역이"+count+ " 개가 있으므로 삭제불가합니다!")
				}
			}
		});
	});

</script>
</html>