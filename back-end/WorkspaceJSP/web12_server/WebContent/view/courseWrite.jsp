<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 등록</title>
<link rel="stylesheet" href="css/server.css">
</head>
<body>
<div>
<h1>교과목 등록</h1>
<form action="RS" method="post">
<input type="hidden" name="command" value="course_write">
	<table>
		<tr>
			<td>교과목 코드</td>
			<td> <input type="text" name="id" required> </td>
		</tr>
		<tr>
			<td>과목명 </td>
			<td> <input type="text" name="name" required> </td>
		</tr>
		<tr>
			<td>담당 강사</td>
			<td>
				
				<select name="lecturer" required>
						<option value="none">담당 강사 선택</option>
					<c:forEach var="lecturer" items="${lecturerList}">
						<option value="${lecturer.idx}">${lecturer.name}</option>
					</c:forEach>
				</select>				
			</td>
		</tr>
		<tr>
			<td>학점</td>
			<td> <input type="text" name="credit" required> </td>
		</tr>
		<tr>	
			<td>요일</td>
			<td>
				<input type="radio" name="week" value="1" required>월
				<input type="radio" name="week" value="2" >화
				<input type="radio" name="week" value="3" >수
				<input type="radio" name="week" value="4" >목
				<input type="radio" name="week" value="5" >금			
			</td>
		</tr>
		<tr>	
			<td>시작</td>
			<td> <input type="text" name="start_hour" required> </td>
		</tr>
		<tr>
			<td>종료</td>
			<td> <input type="text" name="end_hour" required> </td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='RS?command=join_list'">
	<input type="submit" value="완료">
</form>
</div>
</body>
</html>