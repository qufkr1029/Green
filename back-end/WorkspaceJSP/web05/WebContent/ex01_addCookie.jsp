<%@page import="javax.swing.plaf.basic.BasicToolBarSeparatorUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>쿠키생성</h2>
<%
	// 1. 쿠키 객체를 생성합니다.
	Cookie c = new Cookie("userId", "hong");
	out.println(c.getName()+c.getValue());
	
	// 쿠키 value값 변경하기
	/* c.setValue("park");
	out.println(c.getName()+c.getValue()); */

	// 2. 유효시간을 설정 => 초 단위
	c.setMaxAge(60*60*24*365);  // 1년 
	
	// 3. 클라이언트에 쿠키 객체 전송
	response.addCookie(c);
	
	response.addCookie(new Cookie("userPwd", "1234"));
	response.addCookie(new Cookie("userName", "홍길동"));
	response.addCookie(new Cookie("userAge", "32"));
	
%>
</body>
</html>