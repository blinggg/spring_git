<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students list</title>
</head>
<body>
   <h1>Students list</h1>
   <a href="insert">입력</a>
   <table border=1>
      <tr>
         <th>학생번호</th>
         <th>학생이름</th>
         <th>학생학과</th>
         <th>학생학년</th>
         <th>학생생일</th>
         <th>지도교수</th>
      </tr>
      <c:forEach items="${list}" var="vo">
      <tr>
         <td>${vo.scode}</td>
         <td>${vo.sname}</td>
         <td>${vo.dept}</td>
         <td>${vo.year}</td>
         <td>${vo.birthday}</td>
         <td>${vo.advisor}:${vo.pname}</td>
      </tr>
      </c:forEach>
   </table>
</body>
</html>