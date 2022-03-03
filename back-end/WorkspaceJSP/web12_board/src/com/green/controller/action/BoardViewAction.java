package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 상세보기 기능
		// num 읽어오기
		// num으로 게시물 정보 얻어오기
		// 뷰페이지에 게시물 정보 넘겨주기
		String url = "board/boardView.jsp";
		
		String num = request.getParameter("num");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateReadCount(num);
		BoardVO bVo = dao.selectBoardByNum(num);
		
		request.setAttribute("board", bVo);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
