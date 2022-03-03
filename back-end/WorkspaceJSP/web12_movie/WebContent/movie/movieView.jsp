<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세보기</title>
</head>
<body>
<div>
	<h1>영화 상세보기</h1>
	<table>
		<tr>
			<th colspan="3">영화제목</th>
			<td>${movie.title}</td>
		</tr>
		<tr>
			<th>감독</th>
			<td>${movie.director}</td>
			<th>출연배우</th>
			<td>${movie.actor}</td>
		</tr>
		<tr>
			<th>별점</th>
			<td>${movie.star}</td>
			<th>가격</th>
			<td>${movie.price}</td>
		</tr>
		<tr>
			<td colspan="4">		
				<input type="button" value="게시글 수정" 
				onclick="location.href='MS?command=movie_update_form&code=${movie.code}'">
				<input type="button" value="게시글 삭제" 
				onclick="location.href='MS?command=movie_delete_form&code=${movie.code}'">
				<input type="button" value="목록 보기" onclick="location.href='MS?command=movie_list'" >
		
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	function openWin(url,info){
		window.open(url,info,"width=500, height=400");
	}
</script>
</body>
</html>