<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type">
<title>부모창입니다</title>
<script language="javascript">
	function getCookie(name) {
		var Found = false
		var start, end
		var i = 0
		// cookie 문자열 전체를 검색
		while (i <= document.cookie.length) {
			start = i
			end = start + name.length
			// name과 동일한 문자가 있다면
			if (document.cookie.substring(start, end) == name) {
				Found = true
				break
			}
			i++
		}
		// name 문자열을 cookie에서 찾았다면
		if (Found == true) {
			start = end + 1
			end = document.cookie.indexOf(";", start)
			// 마지막 부분이라 는 것을 의미(마지막에는 ";"가 없다)
			if (end < start)
				end = document.cookie.length
				// name에 해당하는 value값을 추출하여 리턴한다.
			return document.cookie.substring(start, end)
		}
		// 찾지 못했다면
		return ""
	}

	function openModal() {
		var eventCookie = getCookie("memo");
		if (eventCookie != "no")
			jQuery(document).ready(function() {

				$("#modal").show();

			});
		// window.open('팝업창 웹페이지','윈도우명',); 

		/* 옵션
		 새창 뛰울때 용도에 맞게 옵션 설정을 해줍니다. "YES" 또는 "NO" 로 지정 해주면 됩니다. 
		 menubar - 파일, 편집, 보기....부분 
		 toolbar - 뒤로, 앞으로, 새로고침 아이콘등이 있는 부분 
		 directories - 연결 디렉토리가 표시되는 부분 
		 location - 주소 입력창 
		 status - 아래 브라우저 상태 바 
		 scrollbars - 스크롤 
		 resizable - 리사이즈 옵션 */

		//팝업창의 주소, 같은 도메인에 있어야 한다.
	}
	openModal();
</script>
</head>
<body>
</body>
</html>