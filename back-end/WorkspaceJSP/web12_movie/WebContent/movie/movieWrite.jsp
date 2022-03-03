<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
</head>
<body>
<div>
<h1>영화 등록</h1>
<form action="MS" method="post">
	<input type="hidden" name="command" value="movie_write">
	<table>
		<tr>
			<th>제목</th>
			<td> <input type="text" name="title" required>*필수</td>
		</tr>
		<tr>
			<th>감독</th>
			<td> <input type="text" name="director" required>*필수</td>
		</tr>
		<tr>
			<th>배우</th>
			<td> <input type="text" name="actor" required>*필수</td>
		</tr>
		<tr>
			<th>가격</th>
			<td> <input type="text" name="price" required>*필수</td>
		</tr>
		<tr>
			<th>평점</th>
			<td> <input type="text" name="star" required>*필수</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록하기">
				<input type="reset" value="다시작성">
				<input type="button" value="돌아가기" onclick="location.href='MS?command=movie_list'">			
			</td>
		</tr>
	</table>
</form>	
</div>
</body>
</html>