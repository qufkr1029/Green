package com.green.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDAO;
import com.green.vo.MovieVO;

public class MovieUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정 기능
		MovieVO mVo = new MovieVO();
		
		mVo.setCode(Integer.parseInt(request.getParameter("code")));
		mVo.setActor(request.getParameter("actor"));
		mVo.setDirector(request.getParameter("director"));
		mVo.setPrice(request.getParameter("price"));
		mVo.setTitle(request.getParameter("title"));
		mVo.setStar(Integer.parseInt(request.getParameter("star")));

		MovieDAO dao = MovieDAO.getInstance();
		dao.updateBoard(mVo);
		
		response.sendRedirect("MS?command=movie_list");
	}

}
