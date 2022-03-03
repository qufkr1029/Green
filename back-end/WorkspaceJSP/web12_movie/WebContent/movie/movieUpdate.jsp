<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 수정</title>
</head>
<body>
<div>
	<h1>영화 수정</h1>
	<form action="MS" method="POST">
		<input type="hidden" name="command" value="movie_update">
		<input type="hidden" name="code" value="${movie.code}">
		
		<table>
			<tr>
				<th colspan="3">영화제목</th>
				<td><input type="text" name="title" value="${movie.title}" required>*필수 입력사항 </td>
			</tr>
			<tr>
				<th>감독</th>
				<td><input type="text" name="director" value="${movie.director}" required>*필수 입력사항</td>
				<th>출연배우</th>
				<td><input type="text" name="actor" value="${movie.actor}" required>*필수 입력사항</td>
			</tr>
			<tr>
				<th>별점</th>
				<td><input type="text" name="star" value="${movie.star}" required>*필수 입력사항</td>
				<th>가격</th>
				<td><input type="text" name="price" value="${movie.price}" required>*필수 입력사항</td>
			</tr>
			<tr>
				<td colspan="4">		
					<input type="submit" value="수정">
					<input type="reset" value="다시 작성">
					<input type="button" value="취소" onclick="location.href='MS?command=movie_view&code=${movie.code}'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>