<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<div>
	<h1></h1>
	<form action="BS" method="post">
		<input type="hidden" name="command" value="board_update">
		<input type="hidden" name="num" value="${board.num}">
		<table>
			<tr>
				<th>작성자</th>
				<td> <input type="text" name="name" value="${board.name}" required> *필수 입력 사항 </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td> <input type="password" name="pass" required> *필수 입력 사항 </td>
			</tr>
			<tr>
				<th>이메일</th>
				<td> <input type="email" name="email" value="${board.email}"></td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td> <input type="text" name="title" value="${board.title}" required> *필수 입력 사항 </td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td> <textarea rows="15" cols="70" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="location.href = 'BS?command=board_list'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>