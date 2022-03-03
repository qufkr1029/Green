package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;
import com.green.vo.CourseVO;
import com.green.vo.LecturerVO;

public class LecturerUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강사 페이지 뷰로 가는 기능
		String idx = request.getParameter("idx");
		
		DAO dao = DAO.getInstance();
		
		LecturerVO iVo = dao.selectByIDX(idx);
		request.setAttribute("lecturer", iVo);		
		
		List<CourseVO> courselist = dao.selectAllCourse();
		request.setAttribute("courseList", courselist);
		
		String url = "view/lecturerUpdate.jsp";		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
