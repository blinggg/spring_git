<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Professors Insert</title>
</head>
<body>
	<h1>[교수등록]</h1>
	<form action="insert" method="post">
		<table border=1>
			<tr>
				<td>교수번호</td>
				<td><input type="text" name="pcode"></td>
			</tr>
			<tr>
				<td>교수이름</td>
				<td><input type="text" name="pname"></td>
			</tr>
		</table>
		<input type=submit value="저장">
		<input type=reset value="취소">
	</form> 
</body>
</html>