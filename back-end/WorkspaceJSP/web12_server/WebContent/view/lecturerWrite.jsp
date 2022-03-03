<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/server.css">
</head>
<body>
<div>
<h1>강사등록</h1>
<form action="RS" method="post">
	<input type="hidden" name="command" value="lecturer_write">
	<table>
		<tr>
			<td>강사 번호</td>
			<td> <input type="text" name="idx" value="${param.i+1}" readonly> </td>
		</tr>
		<tr>
			<td>강사 명</td>
			<td> <input type="text" name="name" required> </td>
		</tr>
		<tr>
			<td>전공</td>
			<td><input type="text" name="major" required></td>
		</tr>
		<tr>
			<td>세부 전공</td>
			<td><input type="text" name="field" required></td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='RS?command=lecturer_list'">
	<input type="submit" value="완료"> 
</form>

</div>
</body>
</html>