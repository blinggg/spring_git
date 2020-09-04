<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>professors list</title>
</head>
<body>
   <h1>Professors List</h1>
   <a href="insert">입력</a>
   <table border=1>
      <tr>
         <th>교수번호</th>
         <th>교수이름</th>
         <th>교수학과</th>
         <th>교수직급</th>
         <th>임용일자</th>
         <th>교수급여</th>
      </tr>
      <c:forEach items="${list}" var="vo">
      <tr>
         <td>${vo.pcode}</td>
         <td>${vo.pname}</td>
         <td>${vo.dept}</td>
         <td>${vo.title}</td>
         <td>${vo.hiredate}</td>
         <td>${vo.salary}</td>
      </tr>
      </c:forEach>
   </table>
</body>
</html>