package com.green.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDAO;

public class MovieDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 영화 삭제 기능
		String code = request.getParameter("code");
		
		MovieDAO dao = MovieDAO.getInstance();
		dao.deleteBoard(code);
		
		response.sendRedirect("MS?command=movie_list");

	}

}
