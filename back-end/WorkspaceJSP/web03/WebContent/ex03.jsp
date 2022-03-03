<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 에러가 발생했을 때 이동할 페이지 --%>
<%@ page errorPage="ex03_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 에러 발생시킬 페이지 --%>
	<%= 2/0 %>
</body>
</html>