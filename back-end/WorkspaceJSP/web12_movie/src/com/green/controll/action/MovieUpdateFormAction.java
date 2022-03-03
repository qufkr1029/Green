package com.green.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDAO;
import com.green.vo.MovieVO;

public class MovieUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie/movieUpdate.jsp";
		String code = request.getParameter("code");
		
		MovieDAO dao = MovieDAO.getInstance();
		MovieVO mVo = dao.selectMovieByCode(code);

	    request.setAttribute("movie", mVo);
	    
	    request.getRequestDispatcher(url).forward(request, response);

	}

}
