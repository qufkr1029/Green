package unit01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LC")
public class LifeCycle extends HttpServlet {
	
 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서브ㅡㄹ릿 인스턴스가 만들어집니다. --init()");
	}

	
	public void destroy() {
		System.out.println("서브ㅡㄹ릿 인스턴스가 사라집니다. --destroy()");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("서블릿 인스턴스가 사용됩니다. -- doGet()");
	
	}

}
