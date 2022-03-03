<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>입력된 값 출력</h3>
1. request객체를 활용한 방법 <br>
아이디 : <%=request.getParameter("userId") %> <br> 
암호 :  <%=request.getParameter("userPw") %> <br>
<hr>
2. EL표기법 사용해서 출력 <br>
아이디 : ${param.userId} <br>
암호 :  ${param["userPw"]} <br>
</body>
</html>