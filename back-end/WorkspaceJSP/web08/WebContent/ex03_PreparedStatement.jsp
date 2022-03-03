<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.Statement" %> 
<%@ page import="java.sql.PreparedStatement" %> 
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 서버 접속 방법 : http://localhost~~~~
	String uId = "scott";
	String uPw = "tiger";
	
	Connection conn = null;
	//Statement stmt = null;
	PreparedStatement psmt = null;

	
	String name = "강길동";		//request.getParameter("name"); 폼에서 받은 내용들을 저장함
	String userId = "kang";		
	String userPwd = "1234";
	String email = "kang@naver.com";
	String phone = "010-1234-5678";
	int admin = 1;

//	String sql = "INSERT INTO member " +
//				" VALUES('"+name+"','"+userId+"','"+userPwd+"','"+email+"','"+phone+"',"+admin+")";
	String sql = "INSERT INTO member  VALUES(?,?,?,?,?,?)";

	
%>

<%
	try{
		// 1단계 : 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 인스턴스 만드는 방법 : 
		// 2단계 : 데이터베이스 연결
		conn = DriverManager.getConnection(url, uId, uPw); 
		// 3단계 : 쿼리문을 실행할 객체를 생성
		//stmt = conn.createStatement();
		psmt = conn.prepareStatement(sql); //미완성의 쿼리문을 넣는다.
		
		// 미완성의 쿼리를 채워서 완성시켜야 한다.
		psmt.setString(1,name);
		psmt.setString(2,userId);
		psmt.setString(3,userPwd);
		psmt.setString(4,email);
		psmt.setString(5,phone);
		psmt.setInt(6,admin);
		
		// 4단계 : 쿼리문을 실행
		int num = psmt.executeUpdate();	// 이미 쿼리를 넣었기 때문에 추가로 쿼리를 넣으면 오류 발생
		
		System.out.println("바뀐 행의 개수 : " + num);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(psmt!=null){psmt.close();}
			if(conn!=null){conn.close();}
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
%>
</body>
</html>