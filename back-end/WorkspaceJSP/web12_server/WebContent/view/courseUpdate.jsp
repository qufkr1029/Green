<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 수정</title>
<link rel="stylesheet" href="css/server.css">
</head>
<body>
<h1>교과목 수정</h1>
<form action="RS" method="post">
<input type="hidden" name="command" value="course_update">
	<table>
		<tr>
			<td>교과목 코드</td>
			<td> <input type="text" name="id" value="${join.id}"></td>
		</tr>
		<tr>
			<td>과목명 </td>
			<td> <input type="text" name="name" value="${join.name}"> </td>
		</tr>
		<tr>
			<td>담당 강사</td>
			<td>
				<select name="lecturer">
					<c:forEach var="lecturer" items="${lecturerList}">
						 <option value="${lecturer.idx}" <c:if test="${join.l_name eq lecturer.name}">selected</c:if>>${lecturer.name}</option> 
					</c:forEach>
				</select>				
			</td>
		</tr>
		<tr>
			<td>학점</td>
			<td> <input type="text" name="credit" value="${join.credit}"> </td>
		</tr>
		<tr>	
			<td>요일</td>
			<td>
				<input type="radio" name="week" value="1" 
				<c:if test = "${join.week eq '1'}">checked</c:if>
				>월
				<input type="radio" name="week" value="2"
				<c:if test = "${join.week eq '2'}">checked</c:if>
				>화
				<input type="radio" name="week" value="3"
				<c:if test = "${join.week eq '3'}">checked</c:if>
				>수
				<input type="radio" name="week" value="4"
				<c:if test = "${join.week eq '4'}">checked</c:if>
				>목
				<input type="radio" name="week" value="5"
				<c:if test = "${join.week eq '5'}">checked</c:if>
				>금			
			</td>
		</tr>
		<tr>	
			<td>시작</td>
			<td> <input type="text" name="start_hour" value="${join.start_hour}" > </td>
		</tr>
		<tr>
			<td>종료</td>
			<td> <input type="text" name="end_hour" value="${join.end_hour}"> </td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='RS?command=join_list'">
	<input type="button" value="취소" onclick="location.href='RS?command=course_view&id=${join.id}'">
	<input type="submit" value="완료">
</form>
</body>
</html>