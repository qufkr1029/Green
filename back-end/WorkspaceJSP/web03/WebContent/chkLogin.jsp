<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String storedId = "green";
	String storedPassword = "1234";
%>

	<%
		// request객체와 response 객체가 존재
		request.setCharacterEncoding("UTF-8"); // 한글깨짐 방지
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println("아이디 : " + userId);
		
		if(userId.equals(storedId) && userPwd.equals(storedPassword)){
	%>
	<!-- if조건이 true일 때 출력되는 HTML 영역 -->
		<h2><%=userId %>님 로그인 성공하셨습니다.</h2>
	<%			
		}else{
	%>
		<h2>아이디 또는 비밀번호가 틀렸습니다.</h2>
	<%			
		}
	
	%>
	
	<%-- 아이디와 암호를 입력받아서 로그인 처리를 하되 성공하면 green님 환영합니다. 실패하면 "아이디 또는 비밀번호가 틀렸습니다." --%>
</body>
</html>