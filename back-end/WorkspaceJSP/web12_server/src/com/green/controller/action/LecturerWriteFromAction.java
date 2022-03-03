package com.green.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LecturerWriteFromAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강사등록 페이지로 넘어가는 기능
		String url = "view/lecturerWrite.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
