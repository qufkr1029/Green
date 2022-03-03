package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.vo.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/productWrite")
public class ProductWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼 입력 페이지 연결
		request.getRequestDispatcher("product/productWrite.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 입력받은 데이터를 데이터베이스에 저장
		
		request.setCharacterEncoding("UTF-8");
		
		String savePath = "C:\\Users\\GREEN\\Desktop\\sample_img";
		int fileSize = 100*1024*1024;  //100MB;
		String encType="UTF-8";
		
		try {
			MultipartRequest multi= new MultipartRequest(
										request,
										savePath,
										fileSize,
										encType,
										new DefaultFileRenamePolicy()
										); 
			ProductVO pVo = new ProductVO();
			
			pVo.setName(multi.getParameter("name"));
			
			pVo.setPrice(Integer.parseInt(multi.getParameter("price")));
			pVo.setPictureurl(multi.getFilesystemName("pictureurl"));
			
			pVo.setDescription(multi.getParameter("description"));
			
			
			ProductDAO dao = ProductDAO.getInstance();
			dao.insertProduct(pVo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("productList");
		
	}

}
