<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지</title>
<link rel="stylesheet" href="./style/product.css">
</head>
<body>
<div id="wrap" align="center">
<h1>상품 수정 페이지 - 관리자</h1>
<form action="productUpdate" method="POST" enctype="multipart/form-data">
	<table>
		<tr>
			<td rowspan="4">
				<c:choose>
					<c:when test="${empty productVo.pictureurl}">
						<img alt="이미지없음" src="/image/noimage.jpg">
					</c:when>
					<c:otherwise>
						<img alt="${productVo.pictureurl}" src="/image/${productVo.pictureurl}">
						<!-- server.xml위치에 경로 등록 <Context docBase="이미지 절대 경로" path="/image" /> -->
					</c:otherwise>
				</c:choose>
				<input type="hidden" name="code" value="${productVo.code}">
			</td>
			<th>상품 명</th>
			<td> <input type="text" name="name" value="${productVo.name}"> </td>
		</tr>
		<tr>
			<th>가격</th>
			<td> <input type="number" name="price" value="${productVo.price}">원 </td>
		</tr>
		<tr>
			<th>사진</th>
			<td> 
				<input type="file" name="pictureurl"><br>
				(주의사항 : 이미지를 변경하고자 할 때만 선택하세요)
				<input type="hidden" name="originPic" value="${productVo.pictureurl}">
			</td>
		</tr>
		<tr>
			<th>설명</th>
			<td> <textarea rows="10" cols="30" name="description">${productVo.description}</textarea> </td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="변경">
				<input type="reset" value="다시 작성">
				<input type="button" value="목록 보기" onclick="location.href='productList'">
			</td>
		</tr>
		
	</table>
</form>
</div>
</body>
</html>