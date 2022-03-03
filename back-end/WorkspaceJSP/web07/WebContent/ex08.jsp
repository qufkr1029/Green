<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>request에 저장된 자바빈의 프로퍼티 값 꺼내보기</h3>
아이디 : ${requestScope.member.userId}<br>
이름 : ${member["userName"]}<br>
</body>
</html>