package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 암호 확인 폼으로 부터 받아온 암호를 체크하는 기능
		String url = null;
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");

		BoardDAO dao = BoardDAO.getInstance();
		
		if(dao.checkPassword(num, pass)) {
			// 암호 확인 성공
			System.out.println("암호 확인 성공");
			url = "board/checkSuccess.jsp";
		}else {
			// 암호 확인 실패
			System.out.println("암호 확인 실패");
			url = "board/boardCheckPass.jsp";
			request.setAttribute("massage", "비밀번호가 틀렸습니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
