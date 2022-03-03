package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;
import com.green.vo.JoinVO;
import com.green.vo.LecturerVO;

public class CourseWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 교과목 등록 폼으로 가는 기능
		
		DAO dao = DAO.getInstance();
		List<JoinVO> joinlist = dao.selectAllJoin();
		request.setAttribute("joinList", joinlist);
		
		List<LecturerVO> lecturerlist = dao.selectAllLecturer();
		request.setAttribute("lecturerList", lecturerlist);
		
		
		
		String url = "view/courseWrite.jsp";		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
