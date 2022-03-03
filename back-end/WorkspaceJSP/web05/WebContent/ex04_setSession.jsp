<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션에 값 저장하기</h2>
<%
	// 세션은 내장객체
	session.setAttribute("id","hong");
	session.setAttribute("pwd","1234");
	session.setAttribute("name","홍길동");
%>
<a href="./ex04_getSession.jsp">세션 저장 확인하기</a>
</body>
</html>