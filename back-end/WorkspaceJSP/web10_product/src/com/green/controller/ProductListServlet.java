package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.vo.ProductVO;


@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스에서 모든 목록을 가져와서 뷰페이지에 보내준다.
		
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductVO> lists = dao.selectAllProduct();
		
		request.setAttribute("productLists", lists);
		
		request.getRequestDispatcher("product/productList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
