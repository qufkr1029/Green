<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션에 저장된 값 읽어오기</h2>
<%
String id = (String)session.getAttribute("id");		// 세션에 값을 저장할 때 값의 정체가 반드시 문자열이 아니다!! 그러므로 형변환 하기
String pwd = (String)session.getAttribute("pwd");
String name = (String)session.getAttribute("name");
%>
아이디 : <%=id %><br>
비밀번호 : <%=pwd %><br>
이름 : <%=name %><br>

<a href="./ex04_getSessionAll.jsp">세션에 저장된 모든 값 확인하기</a>
</body>
</html>