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
	double temp = 37.5;
	//int usertemp = (Integer)request.getParameter("temp");

	if(temp >= Double.valueOf(request.getParameter("temp"))){
		RequestDispatcher dispatcher = request.getRequestDispatcher("noCovid.jsp");	
		dispatcher.forward(request, response);
		//request.getRequestDispatcher("noCovid.jsp").forward(request,response);
		

		
	}else if(temp < Double.valueOf(request.getParameter("temp"))){
		RequestDispatcher dispatcher = request.getRequestDispatcher("chkList.jsp");	
		dispatcher.forward(request, response);
	}
%>
</body>
</html>