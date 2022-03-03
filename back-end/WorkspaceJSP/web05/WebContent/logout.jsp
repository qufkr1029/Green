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
	// 로그아웃 => 세션에 저장된 로그 정보를 삭제
	// 로그 정보를 일일히 삭제
	/* session.removeAttribute("id");
	session.removeAttribute("name"); */
	// 로그 정보를 한꺼번에 삭제
	session.invalidate();
%>
<script>
	alert('로그아웃이 정상적을 되었습니다.');
	location.href = "loginForm.jsp";
</script>
</body>
</html>