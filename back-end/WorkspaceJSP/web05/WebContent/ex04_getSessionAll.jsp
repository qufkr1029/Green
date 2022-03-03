<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션에 저장된 모든 값 확인하기</h2>
<%
	Enumeration<String> names = session.getAttributeNames();
	// 세션에 저장된 모든 Attribute의 이름을 읽어오기 
	
	while(names.hasMoreElements()){
		String name = names.nextElement().toString(); // 세션에 저장된 Attribute의 이름을 순차적으로 읽어온다
		String value = (String)session.getAttribute(name);
		
		out.println(name+" : " + value + "<br>");
	}
%>
</body>
</html>