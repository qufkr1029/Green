<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>스크립트릿을 이용해서 자바빈 생성</h2>
<%
	com.green.beans.Member m1 = new com.green.beans.Member();
	m1.setName("홍길동");
	session.setAttribute("m1", m1);
%>
이름 : <%=m1.getName() %><br>
<!-- ---------------------------------------------------------- -->

<h2>액션태그를 이용해서 자바빈 생성</h2>
<jsp:useBean class="com.green.beans.Member" id="m2" scope="session">	
	<jsp:setProperty name="m2" property="name" value="고길동"/>
</jsp:useBean>
이름 : <jsp:getProperty property="name" name="m2"/><br>
</body>
</html>