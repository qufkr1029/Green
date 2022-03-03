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
// 저장된 데이터
String id = "pink";
String password = "pong";
String name = "아기상어";

// 입력된 데이터
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");

if(id.equals(userId)&&password.equals(userPwd)){
	// 로그인 성공시 로그인 정보를 세션에 저장
	session.setAttribute("id",userId);
	session.setAttribute("name",name);

	response.sendRedirect("Main.jsp");
}else{
	// 로그인 실패시 
	response.sendRedirect("loginForm.jsp");
}
%>
</body>
</html>