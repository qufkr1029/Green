<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/server.css">
</head>
<body>
<div>
${count}명의 강사가 있습니다. <input type="button" value="교과목보기" onclick="location.href='RS?command=join_list'">
<table>
	<tr>
		<td>번호</td>
		<td>강사명</td>
		<td>전공</td>
	</tr>
	
	<c:forEach var="lecturer" items="${lecturerList}">
	<c:set var="i" value="${i+1}"></c:set>
	<tr>
		<td>${i}</td>
		<td>
			<a href="RS?command=lecturer_update_form&idx=${lecturer.idx}">${lecturer.name}</a>
		</td>
		<td>${lecturer.field}</td>
	</tr>
	</c:forEach>
</table>
<input type="button" value="강사등록" onclick="location.href='RS?command=lecturer_write_form&i=${i}'"> 
</div>
</body>
</html>