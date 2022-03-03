<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!    
	int test01 = 30; // 전역변수(클래스의 인스턴스 멤버 변수)
		
	public void a1(){
		System.out.println("메서드");
	}

	public String str(){
		return "안녕하세요";
	}
%>

	<%  // _jspService메서드의 영역
	/* public void a1(){         // 메서드 내부에는 새로운 메서드 선언 불가
		System.out.println("메서드");
	} */
		int num1 = 20;		// 메서드 내부의 루컬변수
		int num2 = 10;
		
		int add = num1 + num2;
		
		//PrintWriter out = request.getWriter();
		
		out.println(num1 + "+" + num2 + "=" + add); // 20 + 10 = 30
				
		// 자바코드와 HTML문서는 전혀 다른 영역
		// out객체의 메서드를 통해서 html로 데이터 출력
		
		// 바로 출력할 수 있는 스크립트릿
		// out.println(num1 + "+" + num2 + "=" + add); 이 구문과 밑에 구문은 같은 표현이다.
	%>
	<br>
	<%=num1 %> <%out.println(num1); %><br> <!-- 같은 표현이다. ; 붙고 안붙는것을 잘 확인하기. -->
	<%=num1 %> + <%=num2 %> = <%=add %>         <% // 이 구문과 위에 구문은 같은 표현이다. %>>
	<%=str() %> <!-- 안녕하세요 -->
	
	<!-- HTML 주석 : 서블릿이 읽지 않으므로 HTML코드에 섞어서 출력 -->
	<%-- JSP 주석 : 서블릿이 주석처리하므로 HTML에 노출 안 됨 --%>
	<% // 자바 주석 : 자바 주석도 사용 가능 %>
</body>
</html>