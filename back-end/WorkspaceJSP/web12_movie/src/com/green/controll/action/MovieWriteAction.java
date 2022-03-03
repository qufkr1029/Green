package com.green.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDAO;
import com.green.vo.MovieVO;

public class MovieWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제적으로 게시글을 등록하기 위한 기능
		
		MovieVO mVo = new MovieVO();
		
		mVo.setActor(request.getParameter("actor"));
		mVo.setDirector(request.getParameter("director"));
		mVo.setPrice(request.getParameter("price"));
		mVo.setStar(Integer.parseInt(request.getParameter("star")));
		mVo.setTitle(request.getParameter("title"));
		
		MovieDAO dao = MovieDAO.getInstance();
		dao.insertMovie(mVo);
		
		response.sendRedirect("MS?command=movie_list");
	}

}
