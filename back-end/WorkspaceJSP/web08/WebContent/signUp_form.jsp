<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입 페이지에 오신것을 환영합니다.</h2>
<form action="save_Data.jsp" method="post">
	이름 : <input type="text" name="userName"><br>
	아이디 : <input type="text" name="userId"> <br>
	패스워드 : <input type="password" name="userPwd"><br>
	이메일 : <input type="email" name="userEmail"><br>
	전화번호 : <input type="text" name="phone"><br>
	관리자 여부 : 예<input type="radio" name="admin" value="1">
				아니오<input type="radio" name="admin" value="0"><br>
	<input type="submit" value="회원가입">
</form>
<form action="check_MemberList.jsp" method="get">
	<input type="submit" value="회원 목록 조회"><br>
</form>
<form action="check_MemberList2.jsp" method="get">
	<input type="submit" value="회원 목록 조회2"><br>
</form>
</body>
</html>