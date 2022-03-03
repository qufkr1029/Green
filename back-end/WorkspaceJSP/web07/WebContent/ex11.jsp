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
<%
	String[] movieList={"스파이더맨","비긴어게인","어벤져스","인셉션","타이타닉","중경삼림","반지의제왕","라라랜드","센과치히로의행방불명","양들의침묵"};
	pageContext.setAttribute("mL", movieList);
%>

<c:forEach items="${mL}" var="movieTitle">
${movieTitle}<br>
</c:forEach>
<hr>
<table border="1">
	<tr>
		<td>인덱스</td>
		<td>카운트</td>
		<td>영화제목</td>
	</tr>
	<c:forEach items="${mL}" var="movieTitle" varStatus="s">
		<tr>
			<td>${s.index}</td>
			<td>${s.count}</td>
			<td>${movieTitle}</td>
		</tr>
	</c:forEach>
</table>

<hr>
<ul>
	<c:forEach items="${mL}" var="movieTitle" varStatus="s">
		<c:choose>
			<c:when test="${s.first}">
				<li style="font-weight:bold; color:red;">${movieTitle}</li>			
			</c:when>
			<c:when test="${s.last}">
				<li style="background-color: blue; color: white;">${movieTitle}</li>			
			</c:when>
			<c:otherwise>
				<li>${movieTitle}</li>
			</c:otherwise>
		</c:choose>
		
	</c:forEach>
</ul>

<hr>

<table border="1">
	<tr>
		<td>인덱스</td>
		<td>카운트</td>
		<td>숫자</td>
	</tr>
	<c:forEach var="cnt" begin="4" end="10" step="2" varStatus="s">
		<tr>
			<td>${s.index}</td>
			<td>${s.count}</td>
			<td>${cnt}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<%
	String names = "고은주:김주평,박민영:박준범,박준혁:설재준,윤정욱:윤가영,허연희:정천욱";
	pageContext.setAttribute("names", names);
%>

<c:forTokens var="name" items="${names}" delims="," varStatus="s">
${name}<br>
</c:forTokens>

<!-- StringTokenizer("문자열") -->
</body>
</html>