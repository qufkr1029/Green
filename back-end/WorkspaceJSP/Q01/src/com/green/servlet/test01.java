package com.green.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.dao.CommentDAO;



@WebServlet("/test01")
public class test01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String commentInfo = request.getParameter("commentInfo");
		System.out.println("읽어온 값 : " + commentInfo);
		
		// JSON 객체로 넘어온 값을 '파싱' => 도구 gson.jar(메이븐에서 다운 받아서 lib폴더에 넣음)
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(commentInfo);
		
		String C_user = data.getAsJsonObject().get("C_user").getAsString();
		String C_Comment = data.getAsJsonObject().get("C_Comment").getAsString();
		String C_Password = data.getAsJsonObject().get("C_Password").getAsString();
		
		System.out.println("넘어온 아이디 : " + C_user);
		System.out.println("넘어온 이름 : " + C_Comment);
		System.out.println("넘어온 비밀번호 : " + C_Password);
		
		
		
//		 request.setCharacterEncoding("UTF-8");
//		 response.setCharacterEncoding("UTF-8");
//		 
//		 String commentInfo = request.getParameter("commentInfo");
//		 System.out.println("얻어온 값 : "+commentInfo);
//		 
//		 JsonParser parser = new JsonParser(); JsonElement data =
//		 parser.parse(commentInfo);
//		 
//		 String C_user = data.getAsJsonObject().get("C_user").getAsString(); String
//		 C_Comment = data.getAsJsonObject().get("C_Comment").getAsString(); String
//		 C_Password = data.getAsJsonObject().get("C_Password").getAsString();
//		 
//		 System.out.println("넘어온 작성자 : " + C_user); System.out.println("넘어온 내용 : " +
//		 C_Comment); System.out.println("넘어온 비밀번호 : " + C_Password);
//		 
//		 CommentDAO dao = CommentDAO.getInstance(); dao.insertComment(C_user,
//		 C_Comment, C_Password);
		
		
//		List<TextVO> list = dao.selectAllText();
//		
//		Gson gson = new Gson();
//		String jsonList = gson.toJson(list);
//
//		PrintWriter out = response.getWriter();
//		
//		out.println(jsonList);			
	}

}
