<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원목록</h3>
<table border = "1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>관리자여부</th>
	</tr>
	<c:forEach var="member" items="${list}" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${member.name}</td>
			<td>${member.userid}</td>
			<td>${member.email}</td>
			<td>${member.phone}</td>
			<td>
				<c:if test="${member.admin == 1}">
					관리자
				</c:if>
			</td>
		</tr>
	 </c:forEach>
	 
</table>
</body>
</html>