package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.controller.action.Action;


@WebServlet("/BS")
public class BoardServlet extends HttpServlet {
	// 게시판에 관한 모든 요청을 처리할 서블릿
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 요청 => localhost:8085/web12_board/BS?command='XXXXXXXX'
		
		String command = request.getParameter("command"); // board_list
		System.out.println("BS에서 요청 받음 확인 : " + command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
//		??????            "인스턴스"
// 		인스턴스를 만드는 클래스 X
// 		인스턴스를 상속하는 클래스 
// 		인스턴스를 구현한 인터페이스 O
		
		if(action != null) {
			action.execute(request,response); // Action타입은 execute메서드를 강제로 발현하는 인터페이스
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		
	}

}
