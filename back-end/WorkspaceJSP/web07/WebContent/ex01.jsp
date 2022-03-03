<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- java의 데이터를 html문서로 출력하는 방법 --%>
<%
	String hello = "안녕하세요";
%>

<h3> 1. 스크립트릿과 out객체를 활용한 방법</h3>
<% out.print(hello); %>

<h3> 2. 표현식을 이용한 방법</h3>
<%=hello %>

<h3> 3. EL표기법을 이용한 방법 </h3>
${"안녕하세요"}

</body>
</html>