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
if(session.getAttribute("name")==null){ // 로그인 되지 않은 상태라면??
	response.sendRedirect("loginForm.jsp");
}else{
%>

	<%=session.getAttribute("name") %>(<%=session.getAttribute("id") %>) 님 환영합니다.<br>
	<!-- 아기상어(pink)님 환영합니다. -->
	<p>오늘도 저희 홈페이지에 방문해주셔서 감사합니다. 오늘도 좋은 화루 되세요</p>

	<form action="logout.jsp" method="POST">
		<input type="submit" value="로그아웃">
	</form>
<%
}
%>
</body>
</html>