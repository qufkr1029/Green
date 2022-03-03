<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.Statement" %> 
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
		Statement stmt = null;
		
		// String sql = "INSERT INTO VALUES('최길동','choi','1234','choi@naver.com','010-1234-5678',1)";
		
		String name = "최길동1";		//request.getParameter("name"); 폼에서 받은 내용들을 저장함
		String userId = "choi1";		
		String userPwd = "1234";
		String email = "choi@naver.com";
		String phone = "010-1234-5678";
		int admin = 1;
	
		String sql = "INSERT INTO member " +
					" VALUES('"+name+"','"+userId+"','"+userPwd+"','"+email+"','"+phone+"',"+admin+")";
		
%>

<%
	try{
		// 1단계 : 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 인스턴스 만드는 방법 : 
		// 2단계 : 데이터베이스 연결
		conn = DriverManager.getConnection(url, uId, uPw); 
		// 3단계 : 쿼리문을 실행할 객체를 생성
		stmt = conn.createStatement();
		// 4단계 : 쿼리문을 실행
		int num = stmt.executeUpdate(sql);	// 데이터베이스에서 데이터를 삽입, 변경, 삭제를 위한 쿼리를 보내기 위한 메서드 => 0이 반환되어 왔다면 수정사항 없음 1은 1개 2는 2개 ....
		
		System.out.println("바뀐 행의 개수 : " + num);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(stmt!=null){stmt.close();}
			if(conn!=null){conn.close();}
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
%>
</body>
</html>