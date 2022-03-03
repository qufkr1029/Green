<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>관리자 페이지</h3>
<p><%=URLDecoder.decode(request.getParameter("name"),"UTF-8")%>(<%=request.getParameter("userId") %>)님 환영합니다.</p>
</body>
</html>