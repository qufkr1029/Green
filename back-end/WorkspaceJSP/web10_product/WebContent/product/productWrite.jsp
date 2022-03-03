<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<link rel="stylesheet" href="./style/product.css">
</head>
<body>
<div id="wrap" align="center">
<h1>상품 등록 페이지 - 관리자</h1>
<form action="productWrite" method="POST" enctype="multipart/form-data">
	<table>
		<tr>
			<th>상품 명</th>
			<td> <input type="text" name="name" required> </td>
		</tr>
		<tr>
			<th>가격</th>
			<td> <input type="number" name="price"  required>원 </td>
		</tr>
		<tr>
			<th>이미지</th>
			<td> <input type="file" name="pictureurl"  > </td>
		</tr>
		<tr>
			<th>설명</th>
			<td> <textarea rows="10" cols="80" name="description"  required></textarea> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="다시 작성">
				<input type="button" value="목록" onclick="location.href='productList'">
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
