<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코로나 예방 수칙</title>
<head>
</head>
<script language="JavaScript">
	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ todayDate.toGMTString() + ";"
	}
	function closeWin() {
		if (document.myform.event.checked)// 폼네임 myform 은 동일해야 합니다.
			setCookie("memo", "no", 1); // 1일 간 쿠키적용 // 부모창에서 지정한 쿠키네임과 일치 해야 합니다.
	}
</script>
<body>
	<form name="myform">
		<div>
				<img src="display?fileName=popup.jpg" width=600 height=600>
		</div>
		<div class="layerBar" style=" margin:0; background:black; color:white">
		<input type="checkbox" name="event" onclick="closeWin()">오늘 하루 이창을 열지 않습니다.
			<input type=button value="닫기" onclick="self.close()">
			</div>
	</form>
</body>
</html>