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
<h1>강사수정</h1>
<form action="RS" method="post">
	<input type="hidden" name="command" value="lecturer_update">
	<table>
		<tr>
			<td>강사 번호</td>
			<td> <input type="text" name="idx"  value="${lecturer.idx}" readonly></td>
		</tr>
		<tr>
			<td>강사 명</td>
			<td> <input type="text" name="name"  value="${lecturer.name}" required  > </td>
		</tr>
		<tr>
			<td>전공</td>
			<td><input type="text" name="major" value="${lecturer.major}" required ></td>
		</tr>
		<tr>
			<td>세부 전공</td>
			<td><input type="text" name="field" value="${lecturer.field}"  required ></td>
		</tr>
		<tr>
			<td>담당 과목</td>
			<td>
				<c:forEach var="course" items="${courseList}" >
					<c:if test="${course.lecturer eq lecturer.idx}">${course.name },</c:if> 
				</c:forEach>
			</td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='RS?command=lecturer_list'">
	<input type="submit" value="완료"> 
</form>

</div>
</body>
</html>