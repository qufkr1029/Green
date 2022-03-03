package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제적으로 게시글을 등록하기 위한 기능
		
		BoardVO bVo = new BoardVO();
		
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertBoard(bVo);
		
		response.sendRedirect("BS?command=board_list");
		
	}

}
