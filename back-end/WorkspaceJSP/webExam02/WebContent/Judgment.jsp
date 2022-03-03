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
//RequestDispatcher dispatcher = request.getRequestDispatcher("noCovid.jsp");	
//dispatcher.forward(request, response);
	if(request.getParameter("name1").equals("no") && request.getParameter("name2").equals("no") && request.getParameter("name3").equals("no")){
		RequestDispatcher dispatcher = request.getRequestDispatcher("noCovid.jsp");	
		dispatcher.forward(request, response);
	}else{
		
	}
%>

</body>
</html>