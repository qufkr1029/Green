<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<link rel="stylesheet" href="css/board.css">
</head>
<body>
<div id ="wrap">
<form action="BS" method="post">
	<input type="hidden" name="command" value="board_write">
	<table>
		<tr>
			<th>작성자</th>
			<td> <input type="text" name="name" required> * 필수 </td>			
		</tr>
		<tr>
			<th>비밀번호</th>
			<td> <input type="password" name="pass" required> * 필수(게시물 수정/삭제시 필요) </td>			
		</tr>
		<tr>
			<th>이메일</th>
			<td> <input type="email" name="email"></td>			
		</tr>
		<tr>
			<th>글제목</th>
			<td> <input type="text" name="title" required> * 필수 </td>			
		</tr>
		<tr>
			<th>본문</th>
			<td> <textarea rows="15" cols="70" name="content"></textarea> </td>			
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="글 작성">
				<input type="reset" value="글 다시작성">
				<input type="button" value="목록보기" onclick="location.href = 'BS?command=board_list'"> 
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>