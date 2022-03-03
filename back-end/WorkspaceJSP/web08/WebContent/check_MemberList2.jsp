<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 데이터 베이스에 연결하기 위해서 밑에 4가지 임포트문을 작성해주어야한다 --%>
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
	// 오라클 DB에 접속하기 위한 5가지 정보
	// 1. 서버주소 : localhost / IP주소 
	// 2. 포트번호 : 1521
	// 3. sid : xe / orcl
	// 4. userId : green00 / scott
	// 5. userPassWord : **** / tiger
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 서버 접속 방법 : http://localhost~~~~
	String uId = "scott";
	String uPw = "tiger";
	
	String sql = "SELECT * FROM member"; // 쿼리를 작성하는 문자열에 ; 사용하면 안된다.
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
%>
<ul>
<%

	try{
		// 1단계 : 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 인스턴스 만드는 방법 : 
		// 2단계 : 데이터베이스 연결
		conn = DriverManager.getConnection(url, uId, uPw); 
		// 3단계 : 쿼리문을 실행할 객체를 생성
		stmt = conn.createStatement();
		// 4단계 : 쿼리문을 실행
		rs = stmt.executeQuery(sql); 			// 데이터베이스에서 데이터를 '읽어오기' 위한 쿼리를 보내기 위한 메서드 => SELECT
		// int 변수 = stmt.executeUpdate(sql);	// 데이터베이스에서 데이터를 삽입, 변경, 삭제를 위한 쿼리를 보내기 위한 메서드 => 0이 반환되어 왔다면 수정사항 없음 1은 1개 2는 2개 ....
		
		
/*		
		// 5-1 단계 : 얻어온 데이터를 자바로 출력
			int num = 1;
			out.print("<table border = 1>");
			out.print("<tr><td>번호</td><td>이름</td><td>아이디</td><td>이메일</td><td>전화번호</td><td>관리자</td></tr>");
		while(rs.next()){
			out.print("<tr>");
			out.print("<td>" + num + "</td>");
			out.print("<td>"+rs.getString("name")+"</td>");
			out.print("<td>"+rs.getString("userid")+"</td>");
			out.print("<td>"+rs.getString("email")+"</td>");
			out.print("<td>"+rs.getString("phone")+"</td>");
			out.print("<td>"+rs.getString("admin")+"</td>");
			out.print("</tr>");
			num ++;
		}
		out.print("</table>");
*/
		

	
		List<Member> mList = new ArrayList<>();
		// 5-2 단계 : 얻어온 데이터 저장
		 while(rs.next()){
			Member m = new Member();
			m.setUserid(rs.getString("userid"));
			m.setUserpwd(rs.getString("userpwd"));
			m.setName(rs.getString("name"));
			m.setEmail(rs.getString("email"));
			m.setPhone(rs.getString("phone"));
			m.setAdmin(rs.getInt("admin"));
			
			// 하나의 자바빈 인스턴스 = 하나의 데이터 레코드;
			mList.add(m);
			
		}
		// mList는 모든 레코드 데이터가 저장됨
		// mList.get(0).getName();  : 리스트의 0번 레코드의 이름을 꺼내세요
		
		// 전체 레코드 정보를 다른 JSP에 넘겨줄 때
		request.setAttribute("list", mList); 

		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			if(conn!=null){conn.close();}
		}catch(Exception e){
			e.printStackTrace();	
		}
	}

%>
</ul>
</body>
</html>












