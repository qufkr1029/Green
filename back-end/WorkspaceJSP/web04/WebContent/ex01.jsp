<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
컨텍스트 패스 : <%=request.getContextPath() %><br>
요청 방식 : <%=request.getMethod() %><br>
서버 이름 : <%=request.getServerName() %><br>
요청한 URI : <%=request.getRequestURI() %><br> 
요청한 URL : <%=request.getRequestURL() %><br>
프로토콜 : <%=request.getProtocol() %><br>
	
	
	
	
	
	
	
</body>
</html>