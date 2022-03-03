package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hello")  // 서블릿을 찾기 위한 매핑주소 (새로운 방법)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html"); //어떤 문서로 응답할 것인가?
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Hello Servlet!</h1>");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
