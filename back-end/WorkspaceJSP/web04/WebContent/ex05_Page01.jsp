<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 각 저장영역에 데이터 저장
pageContext.setAttribute("name", "Page Data");
request.setAttribute("name", "Request Data");
session.setAttribute("name", "Session Data");
application.setAttribute("name", "Application Data");

System.out.println("ex05_Page01.jsp");
System.out.println("하나의 페이지 속성 : " + pageContext.getAttribute("name"));
System.out.println("하나의 요철 속성 : " + request.getAttribute("name"));
System.out.println("하나의 세션 속성 : " + session.getAttribute("name"));
System.out.println("하나의 애플리케이션 속성 : " + application.getAttribute("name"));

request.getRequestDispatcher("ex05_Page02.jsp").forward(request, response); // 포워드방식 이동 : request객체 유지


%>
</body>
</html>