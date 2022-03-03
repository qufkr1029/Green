package com.green.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.beans.Member;


@WebServlet("/InputMemberServlet")
public class InputMemberServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//자바 빈을 생성 
		Member member = new Member();
		
		// 자바빈에 프로퍼티 값 저장
		member.setUserId("hong");
		member.setUserName("홍길동");
		
		// 자바빈 객체를 request에 저장해봅시다.
		request.setAttribute("member", member);
		
		// JSP로 전달
		request.getRequestDispatcher("ex08.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
