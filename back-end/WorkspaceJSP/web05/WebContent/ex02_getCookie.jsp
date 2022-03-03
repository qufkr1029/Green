<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>쿠키를 읽어 옵니다.</h2>
<%
	// 1. 클라이언트에 저장된 모든 쿠키를 배열 형태로 읽어옵니다.
	Cookie[] cookies = request.getCookies();

	// 2. 반복의 형태로 데이터 조회
	for(Cookie c:cookies){
		out.println(c.getName()+" : "+c.getValue()+"<br>");		
	}
%>
<a href="./ex03_removeCookie.jsp">쿠키 삭제</a>
</body>
</html>