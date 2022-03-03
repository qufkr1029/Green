package com.green.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDAO;
import com.green.vo.MovieVO;

public class MovieViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 영화 상세보기 기능
		// code 읽어오기
		// code로 게시물 정보 얻어오기
		// 뷰페이지에 게시물 정보 넘겨주기
		String url = "movie/movieView.jsp";
		
		String code = request.getParameter("code");
		
		MovieDAO dao = MovieDAO.getInstance();
		MovieVO mVo = dao.selectMovieByCode(code);
		
		request.setAttribute("movie", mVo);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
