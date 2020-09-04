<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[주소등룍]</title>
</head>
<body>
	<h1>[주소등룍]</h1>
	<form action="insert" method="post">
		<table id=tbl>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"></td>
			</tr>
		</table>
		<input type=submit value=저장>
		<input type=reset value=취소>
	</form>
</body>
<script>
</script>
</html>