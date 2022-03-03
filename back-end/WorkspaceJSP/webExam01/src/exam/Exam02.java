package exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02")
public class Exam02 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = "qufkr1029";
		String Pwd = "1234qwer";
		
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpassword");
		
		if(Id.equals(userId) && Pwd.equals(userPwd)) {
			System.out.println("로그인 성공!");
		}else {
			System.out.println("로그인 실패ㅠ..ㅠ");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
