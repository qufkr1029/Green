<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.beans.Member" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 액션태그 없이 자바빈 사용하기
	// 1. 자바빈 생성
	com.green.beans.Member m1 = new com.green.beans.Member();
	
	// 2. 자바빈에 정보를 저장
	m1.setName("스캣");
	m1.setUserId("cat");	
%>
이름 : <%=m1.getName() %>
이름 : <%=m1.getUserId() %>

<%
	// 1-1. 임포트후 자바빈 생성
	Member m2 = new Member();

	// 3. 자바빈을 세션(내장객체)에 저장
	session.setAttribute("member1", m1);
	
	// 3-1. 세션(내장객체)에 저장된 자바빈 꺼내오기
	Member m3 = (Member)session.getAttribute("member1");
%>
<%-- 자바빈을 액션 태그를 통해서 생성하기 --%>
<jsp:useBean id="m4" class="com.green.beans.Member" scope="request"/>
<%
	//=> 
	//com.green.beans.Member m4 = new com.green.beans.Member();
	//request.setAttribute("m4", m4);
%>
</body>
</html>