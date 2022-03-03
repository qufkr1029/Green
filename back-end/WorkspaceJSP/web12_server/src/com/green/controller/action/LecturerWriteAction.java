package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;
import com.green.vo.CourseVO;
import com.green.vo.LecturerVO;

public class LecturerWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강사 등록 기능
	
		
		LecturerVO lVo = new LecturerVO();
		
		lVo.setIdx(Integer.parseInt(request.getParameter("idx")));
		lVo.setName(request.getParameter("name"));
		lVo.setMajor(request.getParameter("major"));
		lVo.setField(request.getParameter("field"));
		
		
		DAO dao = DAO.getInstance();
		dao.insertLecturer(lVo);
		
		response.sendRedirect("RS?command=lecturer_list");
		
	}

}
