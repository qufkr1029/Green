package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;
import com.green.vo.JoinVO;
import com.green.vo.LecturerVO;

public class CourseUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 교과목 업데이트 뷰로 넘어가는 기능
		String id = request.getParameter("id");
		
		DAO dao = DAO.getInstance();
		JoinVO jVo = dao.selectJoinByID(id);
	    request.setAttribute("join", jVo);

	    List<LecturerVO> lecturerlist = dao.selectAllLecturer();
		request.setAttribute("lecturerList", lecturerlist);

		String url = "view/courseUpdate.jsp";		
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
