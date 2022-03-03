package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.green.dao.DAO;
import com.green.vo.JoinVO;

public class CourseViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 교과목 상세보기 기능
		// id 읽어오기
		// id로 게시물 정보 얻어오기
		// 뷰페이지에 게시물 정보 넘겨주기
		String url = "view/courseView.jsp";
		
		String id = request.getParameter("id");
		
		DAO dao = DAO.getInstance();
		JoinVO jVo = dao.selectJoinByID(id);
		
		request.setAttribute("join", jVo);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
