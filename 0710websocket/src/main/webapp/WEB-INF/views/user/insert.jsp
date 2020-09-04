<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	 <h1>[회원가입]</h1>
    <form name="frm" action="insert" method="post">
        <table border=1 width=400>
            <tr>
               <td width=100>회원 아이디</td><td>
               		<input type="text" name="id" size=10>
               		<a href="#" id="btnCheck">중복체크</a>
               </td>
            </tr>
            <tr>
                <td width=100>회원 비밀번호</td>
                <td><input type="password" name="pass" size=10></td> </tr>
            <tr>
                <td width=100>회원 성명</td>
                <td><input type="text" name="name" size=10></td>
            </tr>
        </table>
        <input type="submit" value="가입">
        <input type="reset" value="취소">
    </form>
</body>
<script>

	
	//유효성검사
	var check=false;
	$(frm).submit(function(e){
		e.preventDefault();
		if(!check){
			alert("아이디 중복체크를 하세요!~");
		}else{
			alert("가입이 완료되었어요~");
			frm.submit();
			
		}
	});
	
	//아이디가 바뀌었을때 유효성검사
	$(frm.id).change(function(){
		check=false;
	});
	
	//중복체크를 눌렀을 때
	$("#btnCheck").on("click", function(e){
		var id=$(frm.id).val();
		e.preventDefault();
		$.ajax({
			type:"post",
			url:"/user/login",
			data:{"id":id},
			success:function(data){
				if(data!=0){
					alert("아이디가 이미 존재합니다.");
					$(frm.id).focus();
				}else{
					alert("사용할 수 있는 아이디 입니다!");
					check=true;
				}
			}
		});
	});
</script>
</html>