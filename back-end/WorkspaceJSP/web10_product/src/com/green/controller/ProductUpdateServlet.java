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


@WebServlet("/productUpdate")
public class ProductUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// code를 통해 읽어온 데이터를 수정 폼에 보여주기
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO pVo = dao.selectProductByCode(code);
		
		request.setAttribute("productVo", pVo);
		
		request.getRequestDispatcher("product/productUpdate.jsp").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정폼에서 받은 내용으로 데이터베이스 내용을 수정하기
		request.setCharacterEncoding("UTF-8");
		
		String savePath = "C:\\Users\\GREEN\\Desktop\\sample_img";
		int fileSize = 100*1024*1024;  //100MB;
		String encType="UTF-8";
		
		try {
			MultipartRequest multi = new MultipartRequest(
												request,
												savePath,
												fileSize,
												encType,
												new DefaultFileRenamePolicy()
												);
			
			int code = Integer.parseInt(multi.getParameter("code"));
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String pictureurl = multi.getFilesystemName("pictureurl");
			String description = multi.getParameter("description");
			
			if(pictureurl == null) { //사진 수정 없음
				pictureurl = multi.getParameter("originPic");
			}
			
			ProductVO pVo = new ProductVO();
			pVo.setCode(code);
			pVo.setName(name);
			pVo.setPrice(price);
			pVo.setPictureurl(pictureurl);
			pVo.setDescription(description);
			
			ProductDAO dao = ProductDAO.getInstance();
			dao.updateProduct(pVo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("productList");
		
		
		
		
		
		
		
		
		
		
		
	}

}
