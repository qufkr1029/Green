<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8"); //post 방식으로 한글 전송시 깨짐 방지
	
	String id = "green";
	String password = "1234";
	
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	
	if(id.equals(userId) && password.equals(userPwd)){
		// 로그인 성공!!!
		// 리다이렉트 방식 :
		response.sendRedirect("ex04_main.jsp?userId="+userId);

		// 포워드 : 
		// RequestDispatcher dispatcher = request.getRequestDispatcher("ex04_main.jsp");
		// dispatcher.forward(request, response);
	}else{
		// 로그인 실패... 
		response.sendRedirect("ex04_loginFail.jsp");
	}


%>
