<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
다음과 같은 에러 발생
<%= exception.getMessage() %>

<h2>현재 페이지는 공사중입니다.</h2>
</body>
</html>