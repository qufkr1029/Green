<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>쿠키를 삭제합니다</h2>
<%
	// 쿠키를 삭제하는 기능은 없다!
	
	// 쿠키를 삭제하는 법 : 같은 이름의 새로운 쿠키를 만들어서 덮어쓰기
	
	Cookie c = new Cookie("userAge","지울용도입니당");  // 같은 이름의 쿠키가 있는 경우 새로운 쿠키로 변경
	c.setMaxAge(0);  // 새로운 쿠키의 유효시간을 0으로 지정 => 유효시간을 0으로 지정하면 쿠키가 삭제가 됨
	response.addCookie(c);
%>
<a href="./ex02_getCookie.jsp">삭제된 쿠키 확인</a>
</body>
</html>