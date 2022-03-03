<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>저희 홈페이지를 방문해주셔서 감사합니다.</h2>
	<p><%=request.getParameter("userId") %>님 환영합니다</p> <!-- null님 환영합니다. -->
</body>
</html>