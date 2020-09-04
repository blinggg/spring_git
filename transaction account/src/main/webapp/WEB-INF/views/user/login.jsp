<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
    <title>로그인</title>
<style>
	#login{border:1px solid #BFB4AC;text-align:center;width:300px;border-collapse: collapse;}
	.title{background:#F2BFAB;}
	.row:hover{background:#E7DBD3;color:white;}
	td{border:1px solid #BFB4AC;}
	
</style>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
    <h1>[로그인]</h1>
    <form name=frm action="login" method="post">
        <table width=300 border=1 id="login">
            <tr class="title"><td>아이디:</td><td class=row><input type="text" name="id" size=10></td></tr>
            <tr class="title"><td>비밀번호</td><td class=row><input type="password" name="pass" size=10></td></tr>
            <!-- <tr><td>이름</td><td><input type="text" name="name" size=5></td></tr>-->
            <tr><td colspan=2><input type="submit" value="로그인"></td></tr>
        </table>
    </form>
</body>
<script>
	//로그인 버튼을 눌렀을 때
	$(frm).submit(function(e){
		var id=$(frm.id).val();
		var pass=$(frm.pass).val();
		e.preventDefault();
		$.ajax({
			type:"post",
			url:"/user/login",
			dataType:"json",
			data:{"id":id,"pass":pass},
			success:function(data){
				if(data==0){
					alert("아이디가 존재하지 않습니다.");
				}else if(data==1){
					alert("비밀번호가 존재하지 않습니다.");
				}else{
					alert("성공");
					//location.href="/user/list?id="+id;
					location.href="/";
				}
			}
		});
	});





</script>
</html>