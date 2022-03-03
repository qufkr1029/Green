package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;

public class CourseDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 영화 삭제 기능
		String id = request.getParameter("id");
		
		DAO dao = DAO.getInstance();
		dao.deleteCourse(id);
		
		response.sendRedirect("RS?command=join_list");
	}

}
