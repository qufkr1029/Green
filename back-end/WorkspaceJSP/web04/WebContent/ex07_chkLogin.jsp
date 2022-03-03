<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] admin = {"admin", "1234"};
String[] user = {"user", "5678"};

String inputId = request.getParameter("userId");
String inputPwd = request.getParameter("userPwd");

if(admin[0].equals(inputId)&&admin[1].equals(inputPwd)){ // 관리자 로그인
%>
	<jsp:forward page="ex07_admin.jsp">
		<jsp:param value='<%=URLEncoder.encode("관리자", "UTF-8")%>' name="name"/>
	</jsp:forward>
<%
}else if(user[0].equals(inputId)&&user[1].equals(inputPwd)){ // 유저 로그인
%>
	<jsp:forward page="ex07_user.jsp">
		<jsp:param value='<%=URLEncoder.encode("박준범", "UTF-8")%>' name="name"/>
	</jsp:forward>
<%
}else{ // 로그인 실패
%>
	 <script>
	 	alert('로그인 실패 : 아이디 또는 비밀번호가 틀립니다.');
	 	history.go(-1); // 이전 페이지로 이동
	 </script>
	 
<%
}
%>





</body>
</html>