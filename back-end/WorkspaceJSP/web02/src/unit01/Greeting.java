package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/G")
public class Greeting extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "안녕하세요";
		
		// 한글 출력시 깨짐 방식 : charset=UTF-8
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+str+"</h1>");
		out.println("</body></html>");
		
	}

}
