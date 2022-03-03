package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;
import com.green.vo.CourseVO;

public class CourseWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제적으로 교과목을 등록하기 위한 기능
		
		CourseVO cVo = new CourseVO();
		
		cVo.setId(request.getParameter("id"));
		cVo.setName(request.getParameter("name"));
		cVo.setCredit(Integer.parseInt(request.getParameter("credit")));
		cVo.setLecturer(Integer.parseInt(request.getParameter("lecturer")));
		cVo.setWeek(Integer.parseInt(request.getParameter("week")));
		cVo.setStart_hour(Integer.parseInt(request.getParameter("start_hour")));
		cVo.setEnd_hour(Integer.parseInt(request.getParameter("end_hour")));
		
		
		
		DAO dao = DAO.getInstance();
		dao.insertCourse(cVo);
		
		response.sendRedirect("RS?command=join_list");

	}

}
