package com.green.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.DAO;
import com.green.vo.JoinVO;


public class JoinListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 조인된 교과목 리스트를 가져와서 뷰로 연결 시켜주는 메서드
		
		DAO dao = DAO.getInstance();
		int	cnt = dao.countCourse();
		request.setAttribute("count", cnt);
		
		List<JoinVO> joinlist = dao.selectAllJoin();
				
		request.setAttribute("joinList", joinlist);
		
		String url = "/view/joinList.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
