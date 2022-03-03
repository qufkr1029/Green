<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>1. POST에서 한글 깨짐 현상</h3>
<form action="ex17_encoding01.jsp" method="post">
	이름 : <input type="text" name="name">
	<input type="submit" value="전송">
</form>

<hr>
<h3>2. POST에서 한글 깨짐 현상 방지</h3>
<form action="ex17_encoding02.jsp" method="post">
	이름 : <input type="text" name="name">
	<input type="submit" value="전송">
</form>

<hr>
<h3>3. POST에서 한글 깨짐 현상 방지 -fmt을 이용한 방법</h3>
<form action="ex17_encoding03.jsp" method="post">
	이름 : <input type="text" name="name">
	<input type="submit" value="전송">
</form>

</body>
</html>