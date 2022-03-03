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
	request.setCharacterEncoding("UTF-8"); // 한글깨짐 방지
%>
<% // 밑에 경우를 이것중에 하나만(아무거나) 쓰면 됨 %>
<%-- 1. 자바빈 생성 --%>
<%-- 방법1) 스크립트릿에서 자바빈 생성 --%>
	<%
		Member member1 = new Member();
		session.setAttribute("member1", member1);
	%>
<%-- 방법2) 액션태그로 자바빈 생성 --%>
	<jsp:useBean id="member2" class="com.green.beans.Member" scope="session"/>
	
<%------------------------------------------------------------ --%>

<%-- 2. 데이터 입력(폼에서 넘어온 데이터를 자바빈에서 저장하는 방법) --%>
<%-- 방법1) 스크립트릿을 이용해서 데이터 입력 1 --%>
	<%
	/* String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String name = request.getParameter("name");
	String nickName = request.getParameter("nickName");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	member1.setUserId(userId);
	member1.setUserPw(userPw);
	member1.setName(name);
	member1.setNickName(nickName);
	member1.setEmail(email);
	member1.setPhone(phone); */
	%>

<%-- 방법2) 스크립트릿을 이용해서 데이터 입력 2 --%>
	<%
	member1.setUserId(request.getParameter("userId"));
	member1.setUserPw(request.getParameter("userPw"));
	member1.setName(request.getParameter("name"));
	member1.setNickName(request.getParameter("nickName"));
	member1.setEmail(request.getParameter("email"));
	member1.setPhone(request.getParameter("phone"));
	%>
<%-- 방법3) 액션태그를 이용해서 데이터 입력1 --%>
	<%--
	<jsp:setProperty  name="member2" property="userId" value='<%=request.getParameter("userId") %>'/>
	<jsp:setProperty  name="member2" property="userPw" value='<%=request.getParameter("userPw") %>'/>
	<jsp:setProperty  name="member2" property="name" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty  name="member2" property="name" value='<%=request.getParameter("nickName") %>'/>
	<jsp:setProperty  name="member2" property="email" value='<%=request.getParameter("email") %>'/>
	<jsp:setProperty  name="member2" property="phone" value='<%=request.getParameter("phone") %>'/>
	--%>
<%-- 방법4) 액션태그를 이용해서 데이터 입력2 --%>
	<%--
	<jsp:setProperty  name="member2" property="userId"/>
	<jsp:setProperty  name="member2" property="userPw"/>
	<jsp:setProperty  name="member2" property="name"/>
	<jsp:setProperty  name="member2" property="nickName"/>
	<jsp:setProperty  name="member2" property="email"/>
	<jsp:setProperty  name="member2" property="phone"/>
	 --%>
<%-- 방법5) 액션태그를 이용해서 데이터 입력3 --%>
	<jsp:setProperty  name="member2" property="*"/>
	
<%------------------------------------------------------------ --%>

<%-- 3. 데이터 출력(자바빈에 저장된 데이터를 화면으로 출력) --%>
<%-- 방법1) 스크립트릿을 이용해서 데이터 출력 --%>
<h2>스크립트릿을 활용한 회원정보 출력</h2>
아이디 : <%=member1.getUserId() %><br>
비밀번호 : <%=member1.getUserPw() %><br>
이름 : <%=member1.getName() %><br>
별명 : <%=member1.getNickName() %><br>
이메일 : <%=member1.getPhone() %><br>
전화번호 : <%=member1.getUserId() %><br>
<%-- 방법2) 액션태그를 이용해서 데이터 출력 --%>
<h2>액션태그를 활용한 회원정보 출력</h2>
아이디 : <jsp:getProperty name="member2" property="userId" /><br>
비밀번호 : <jsp:getProperty name="member2" property="userPw" /><br>
이름 : <jsp:getProperty name="member2" property="name" /><br>
별명 : <jsp:getProperty name="member2" property="nickName" /><br>
이메일 : <jsp:getProperty name="member2" property="email" /><br>
전화번호 : <jsp:getProperty name="member2" property="phone" /><br>
</body>
</html>