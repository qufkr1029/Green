package unit01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CS")
public class ConnectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get방식");
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpassword");
		String userName = request.getParameter("username");
		String gender = request.getParameter("gender");
		
		String[] hobbys = request.getParameterValues("hobby");  //checkbox등 여러개의 데이터를 받아들일때
		
		System.out.println("아이디 : "+ userId);
		System.out.println("암호 : "+ userPwd);
		System.out.println("이름 : "+ userName);
		
		if(gender.equals("male")) {
			System.out.println("성별 : 남성");
		}else if(gender.equals("female")) {
			System.out.println("성별 : 여성");
		}
		
		for(String hobby : hobbys) {
			System.out.println("취미 : " + hobby);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식");
		request.setCharacterEncoding("UTF-8"); //post방식으로 한글 전송시 깨짐 방지
		
		
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpassword");
		String userName = request.getParameter("username");
		String gender = request.getParameter("gender");
		
		String[] hobbys = request.getParameterValues("hobby");  //checkbox등 여러개의 데이터를 받아들일때
		
		System.out.println("아이디 : "+ userId);
		System.out.println("암호 : "+ userPwd);
		System.out.println("이름 : "+ userName);
		
		if(gender.equals("male")) {
			System.out.println("성별 : 남성");
		}else if(gender.equals("female")) {
			System.out.println("성별 : 여성");
		}
		
		for(String hobby : hobbys) {
			System.out.println("취미 : " + hobby);
		}
	}

}
