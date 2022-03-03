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
<h1>교과목 관리 사이트</h1>
</div>
<div>
총 ${count}개의 교과목~~~~~~~~  <input type="button" value="강사보기" onclick="location.href='RS?command=lecturer_list'">
<table>
	<tr>
		<td>과목코드</td>
		<td>과목 명</td>
		<td>학점</td>
		<td>담당강사</td>
		<td>요일</td>
	</tr>
	
<c:forEach var="join" items="${joinList}">
	<tr>
		<td>${join.id}</td>
		<td> <a href="RS?command=course_view&id=${join.id}">${join.name}</a>  </td>
		<td>${join.credit}</td>
		<td>${join.l_name}</td>
		<td>
			<c:if test="${join.week==1}">월</c:if>
			<c:if test="${join.week==2}">화</c:if>
			<c:if test="${join.week==3}">수</c:if>
			<c:if test="${join.week==4}">목</c:if>
			<c:if test="${join.week==5}">금</c:if>
		</td>
	</tr>
</c:forEach>
	
</table>
<input type="button" value="교과목 등록" onclick="location.href='RS?command=course_write_form'">
</div>
<div>
<h1>Copyright(c)2022 그린 아카데미 All right Reserved</h1>
</div>
</body>
</html>