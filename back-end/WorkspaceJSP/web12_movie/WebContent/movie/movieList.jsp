<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리스트</title>
</head>
<body>
<div>
<h1>영화 리스트</h1>
<table>
<tr>
	<td colspan="3" style="border:white; text-align: right">
		<a href="MS?command=movie_write_form">영화 등록</a>
	</td>	
</tr>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>감독</th>
</tr>
<c:forEach var="movie" items="${movieList}">
		<tr>
			<td>${movie.code}</td>
			<td> <a href="MS?command=movie_view&code=${movie.code}"> ${movie.title}</a></td>
			<td>${movie.director}</td>
		</tr>
</c:forEach>
</table>
</div>
</body>
</html>