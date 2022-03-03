package com.green.controll.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDAO;
import com.green.vo.MovieVO;

public class MovieListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실질적으로 게시물 리스트를 가져와서 뷰에 연결 시켜주는 메서드
		String url = "/movie/movieList.jsp";   // 요청보낼 페이지
		
		MovieDAO dao = MovieDAO.getInstance();
		List<MovieVO> movielist = dao.selectAllMovie();
		
		request.setAttribute("movieList", movielist);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
