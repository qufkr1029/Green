<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/server.css">
</head>
<body>
<div>
<h1>교과목 상세 보기</h1>
<table>
	<tr> 
		<td>교과목 코드</td>
		<td> ${join.id}</td>
	</tr>
	<tr> 
		<td>과목 명</td>
		<td> ${join.name}</td>
	</tr>
	<tr> 
		<td>담당 강사</td>
		<td> ${join.l_name}</td>
	</tr>
	<tr> 
		<td>학점</td>
		<td> ${join.credit}</td>
	</tr>
	<tr> 
		<td>요일</td>
		<td> 
		<c:if test="${join.week==1}">월요일</c:if>
		<c:if test="${join.week==2}">화요일</c:if>
		<c:if test="${join.week==3}">수요일</c:if>
		<c:if test="${join.week==4}">목요일</c:if>
		<c:if test="${join.week==5}">금요일</c:if>
		</td>
	</tr>
	<tr> 
		<td>시작</td>
		<td> ${join.start_hour}</td>
	</tr>
	<tr> 
		<td>종료</td>
		<td> ${join.end_hour}</td>
	</tr>
</table>
<input type="button" value="수정" 
	onclick="location.href='RS?command=course_update_form&id=${join.id}'">
<input type="button" value="삭제" onclick="deleteCourse()">
<input type="button" value="목록" onclick="location.href='RS?command=join_list'" >
</div>
</body>
<script type="text/javascript">
	function deleteCourse() {
		let result = confirm('삭제하시겠습니까?');

	 	if(result == 1){
			alert('삭제하였습니다');
			location.href='RS?command=course_delete&id=${join.id}';
			/* location.href='RS?command=join_list'; */ //목록으로 돌아가기
		}else{
			/* alert('삭제가 취소되었습니다.'); */
		} 
		
	}
</script>
</html>