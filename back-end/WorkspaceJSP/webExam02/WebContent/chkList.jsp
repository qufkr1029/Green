<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.print(request.getParameter("name")+"님은 코로나 바이러스 정밀검사를 진행해 주십시오");
%>
<br>
<form action="Judgment_jsp" method="get">
	발열증상여부 : 	예<input type="radio" name="name1" value="yes">
				아니오<input type="radio" name="name1" value="no"><br>
	호흡기 증상 여부 : 예<input type="radio" name="name2" value="yes">
				   아니오<input type="radio" name="name2" value="no"><br>
	2주내 해외 여행 여부 : 예<input type="radio" name="name3" value="yes">
					   아니오<input type="radio" name="name3" value="no"><br>
	<input type="submit" value="확인">
</form>
</body>
</html>