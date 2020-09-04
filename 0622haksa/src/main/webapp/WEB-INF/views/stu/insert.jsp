<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Insert</title>
</head>
<body>
	<h1>[학생등록]</h1>
	<form action="insert" method="post">
		<table border=1>
			<tr>
				<td>학생번호</td>
				<td><input type="text" name="scode"></td>
			</tr>
			<tr>
				<td>학생이름</td>
				<td><input type="text" name="sname"></td>
			</tr>
		</table>
		<input type=submit value="저장">
		<input type=reset value="취소">
	</form> 
</body>
</html>