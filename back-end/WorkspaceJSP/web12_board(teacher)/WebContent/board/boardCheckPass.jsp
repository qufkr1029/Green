<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호 확인 폼</title>
</head>
<body>
<div align="center">
	<h1>암호 확인</h1>
	<form action="BS" method="POST">
		<input type="hidden" name="command" value="board_check_pass">
		<input type="hidden" name="num" value="${param.num}">
		<table>
			<tr>
				<th>비밀번호</th>
				<td> <input type="password" name="pass" required> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="확인"> </td>
			</tr>
			 <tr>
			 	<td colspan="2">${message}</td>
			 </tr>
		</table>
	</form>
</div>
</body>
</html>