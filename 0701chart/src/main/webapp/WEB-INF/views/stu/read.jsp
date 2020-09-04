<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>students read</title>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<style>
		.title{ background: #87CEFA; color: #EBFBFF;}
		a{text-decoration: none; color:black;}
		.active{color:red;}
		.row:hover { background:#CDECFA; }
	</style>
	<script>
		var scode="${vo.scode}";
	</script>
</head>
<body>
	<h1> [ STUDENTS READ ]</h1>
	<form name="frm" action="update" method="post">
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="scode" value="${vo.scode}">
		<table id="srtbl" border=1>
			<tr>
				<th width=100 class="title">CODE</th>
				<td width=370>${vo.scode}</td>
			</tr>
			<tr>
				<th width=100 class="title">NAME</th>
				<td width=370><input type="text" name="sname" value="${vo.sname}"></td>
			</tr>
			<tr>
				<th class="title">DEPT</th>
				<td>
					<select name="dept">
						<option <c:out value="${vo.dept=='전산'?'selected':''}"/>>전산</option>
						<option <c:out value="${vo.dept=='전자'?'selected':''}"/>>전자</option>
						<option <c:out value="${vo.dept=='건축'?'selected':''}"/>>건축</option>
					</select>

				</td>
			</tr>
			<tr>
				<th class="title">YEAR</th>
				<td><input type="text" value="${vo.year}" name="year"></td>
			</tr>
			<tr>
				<th class="title">BIRTHDAY</th>
				<td><input type="text" value="${vo.birthday}" name="birthday"></td>
			</tr>
			<tr>
				<th class="title">ADVISOR</th>
				<td>
					<input type="text" name="advisor" value="${vo.advisor}">
					<select name="pname">
						<c:forEach items="${plist}" var="pvo">
							<option value="${pvo.pcode}" >${pvo.pname}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
		<input type="button" value="삭제" id="btnDelete">
		<input type="button" value="목록" id="btnList">
	</form>
	<hr>
	<div>
		<select id="lcode">
			<c:forEach items="${clist}" var="vo">
				<option value="${vo.lcode}">${vo.lname} :: ${vo.pname}</option>
			</c:forEach>
		</select>
		<input type="button" value="신청" id="btnInsert">
	</div>
	<div>
	신청 과목 수: <span id="total"></span>
	<table id="etbl" border=1></table>
	<script id="temp" type="text/x-handlebars-template">
		<tr class="title">
			<th width=50>CODE</th>
			<th width=150>NAME</th>
			<th width=100>DATE</th>
			<th width=150>GRADE</th>
		</tr>
		{{#each elist}}
		<tr class="row">
			<td class="lcode">{{lcode}}</td>
			<td class="lname">{{lname}}</td>
			<td class="edate">{{edate}}</td>
			<td >
				<input type="text" class="grade" value="{{grade}}" size=3>
				<input type="button" value="수정" class="btnUpdate">
				<input type="button" value="삭제" class="btnDelete">
			</td>
		</tr>
		{{/each}}
	</script>
	</div>
	<div id="chart">
		<jsp:include page="chart.jsp"/>
	</div>
</body>
<script>
	
	var page="${page}";
	var lcode;
	getList();
	
	$("#etbl").on("click", ".row .btnDelete", function() {
		lcode=$(this).parent().parent().find(".lcode").html();
		if(!confirm("삭제 하시겠습니까?")) return;
		$.ajax({
			type:"post",
			data:{"scode":scode,"lcode":lcode},
			url:"/eno/delete",
			success: function() {
				alert("삭제되었습니다.");
				getList();
				changeChart();
			}
		});
	});
	
	$("#etbl").on("click", ".row .btnUpdate", function() {
		lcode=$(this).parent().parent().find(".lcode").html();
		var grade=$(this).parent().find(".grade").val();
		if(!confirm("수정 하시겠습니까?")) return;
		$.ajax({
			type:"post",
			data:{"scode":scode,"lcode":lcode,"grade":grade},
			url:"/eno/update",
			success: function() {
				alert("수정되었습니다.");
				getList();
				changeChart();
			}
		});
	});
	
	$("#btnInsert").on("click", function() {
		lcode=$("#lcode").val();
		if(!confirm("수강신청 하시겠습니까?")) return;
		$.ajax({
			type:"get",
			data:{"scode":scode,"lcode":lcode},
			url:"/eno/read",
			dataType:"json",
			success: function(data) {
				if(data != 0){
					alert("이미 신청한 강좌입니다!");
				}else{
					$.ajax({
						type:"post",
						data:{"scode":scode,"lcode":lcode},
						url:"/eno/insert",
						success: function() {
							alert("신청이 완료되었습니다.");
							getList();
							changeChart();
						}
					});
				}
			}
		});
	});
	
	function getList() {
		$.ajax({
			type:"get",
			url:"/stu/enoList",
			data:{"scode":scode},
			dataType:"json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#etbl").html(temp(data));
				$("#total").html(data.total);
			}
		});
	}

	$("#btnDelete").on("click",function() {
		if(!confirm("삭제하시겠습니까?")) return;
		$.ajax({
			type:"get",
			url:"/eno/enrollCount",
			data:{"scode":scode},
			dataType:"json",
			success: function(data) {
				if(data != 0){
					alert("수강 신청한 목록 "+data+"개 있어 삭제할 수 없습니다!");
				}else{
					frm.action="delete";
					frm.submit();
				}
			}
		});
	});

	$(frm).submit(function(e) {
		e.preventDefault();
		if(!confirm("수정하시겠습니까?")) return;
		frm.submit();
	});

	$("#btnList").on("click", function() {
		location.href="list?page="+page;
	});

	$(frm.pname).change(function() {
		var pcode=$(frm.pname).val();
		$(frm.advisor).val(pcode);
	});
</script>
</html>