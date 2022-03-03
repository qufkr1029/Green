<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("greet1", "hello1");
%>

<c:set var="greet2" value="hello2" scope="request"/>

<!-- 데이터 출력 -->
<%=request.getAttribute("greet1").toString() %><br>
${greet2}<br>

<c:out value="${greet2}"/><br>

<!-- --------------------------------------------------- -->
<c:set var="add" value="${10+20}"/>
합계 : ${add}<br>

<c:set var="member" value="<%=new com.green.beans.Member() %>"/>
<c:set target="${member}" property="userId" value="king" />
<c:set target="${member}" property="userName">
	장수왕
</c:set>
<br>
아이디 : ${member.userId}<br>
이름 : ${member["userName"]}<br>
<c:out value="${member}"/><br>
${member}

<%
//request.removeAttribute("greet1");
%>
<c:set var="test" value="테스트"/>
변수 선언후 테스트 값 : ${test}<br>

<c:remove var="test"/>

변수 삭제후 테스트 값 : ${test}<br>

</body>
</html>