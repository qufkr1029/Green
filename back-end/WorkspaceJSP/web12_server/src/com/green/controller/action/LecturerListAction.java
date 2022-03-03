package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;
import com.green.vo.LecturerVO;

public class LecturerListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강사목록을 상세보기 기능
		// 조인된 강사 리스트를 가져와서 뷰로 연결 시켜주는 메서드
		
		DAO dao = DAO.getInstance();
		
		int	cnt = dao.countlecturer();
		request.setAttribute("count", cnt);
		
		List<LecturerVO> lecturerlist = dao.selectAllLecturer();				
		request.setAttribute("lecturerList", lecturerlist);
		
		String url = "/view/lecturerList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
