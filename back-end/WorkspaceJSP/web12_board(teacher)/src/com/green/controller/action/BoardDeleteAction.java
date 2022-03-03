package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시판 삭제 기능
		String num = request.getParameter("num");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(num);
		
		response.sendRedirect("BS?command=board_list");
	}

}
