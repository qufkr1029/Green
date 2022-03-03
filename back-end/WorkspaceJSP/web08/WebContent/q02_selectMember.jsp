<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.Statement" %> 
<%@ page import="java.sql.ResultSet" %> 
<%@ page import="java.sql.DriverManager" %>
<%-- 데이터 베이스에 연결하기 위해서 위에 4가지 임포트문을 작성해주어야한다 --%>
<%@ page import="web08.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uId = "scott";
	String uPw = "tiger";	
%>
<%
	Connection con = null;
	Statement stmt= null;
	ResultSet rs = null;
	
	String sql = "SELECT * FROM member";
	
	List<Member> list = new ArrayList<>();
	
	
	try{
		con = DriverManager.getConnection(url,uId,uPw);
		
		stmt = con.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){ // 레코드 = 자바빈 객체
			String name = rs.getString("name");
			String userid = rs.getString("userid");
			String userpwd = rs.getString("userpwd");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			int admin = rs.getInt("admin");		
			
			Member m = new Member();
			m.setName(name);
			m.setUserid(userid);
			m.setUserpwd(userpwd);
			m.setEmail(email);
			m.setPhone(phone);
			m.setAdmin(admin);
			
			list.add(m); // 각 자바빈 -=> 리스트
		}
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		}catch(Exception e){
			
		}
	}
	request.setAttribute("list", list);
	request.getRequestDispatcher("q02_result.jsp").forward(request, response);
	
	



%>

</body>
</html>