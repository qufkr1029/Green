<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>포맷을 활용한 한글 깨짐 현상</h3>
<fmt:requestEncoding value="UTF-8"/>
이름 : ${param.name}
</body>
</html>