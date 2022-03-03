package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;


@WebServlet("/productDelete")
public class ProductDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달받은 코드번호를 통해 해당 레코드 정보를 삭제
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO dao = ProductDAO.getInstance();
		dao.deleteProduct(code);
		
		response.sendRedirect("productList");
		
	}

}
