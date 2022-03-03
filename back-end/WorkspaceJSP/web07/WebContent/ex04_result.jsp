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
	String str1 = request.getParameter("num1"); // 폼에서 넘어온 모든 데이터는 문자열로 처리된다.
	int num1 = Integer.parseInt(str1); // 문자열을 숫자로 변환
	int num2 = Integer.parseInt(request.getParameter("num2"));
%>
<h3>표현식에서의 연산</h3>
	<%=num1 %>+<%=num2 %>=<%=num1+num2 %>
	
	
<hr>
<h3>EL표기법에서의 연산</h3>
${param.num1}+${param.num2}=${param.num1+param.num2}<br>
${param["num1"]}+${param["num2"]}=${param["num1"]+param["num2"]}
</body>
</html>