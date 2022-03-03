package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardUpdate.jsp";
		String num = request.getParameter("num");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO bVo = dao.selectBoardByNum(num);
		
		request.setAttribute("board", bVo);
		
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
