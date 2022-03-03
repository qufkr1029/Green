package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ConComment;
import javax.naming.InitialConComment;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.green.vo.CommentVO;
import com.green.vo.CommentVO;



public class CommentDAO {
	private CommentDAO() {}
	private static CommentDAO dao = new CommentDAO();
	public static CommentDAO getInstance() {
		return dao;
	}
	
	// 데이터베이스 연결 객체를 만드는 메서드
	public Connection getConnection() throws Exception {
		ConComment initConComment = new InitialContext();
		ConComment envConComment  = (ConComment)initConComment.lookup("java:/comp/env");
		DataSource ds = (DataSource)envConComment.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}	
	
	// 
		public void insertComment(String C_user, String C_Comment, String C_Password) {
			
			String sql="INSERT INTO commenttbl VALUES(comment_seq.nextval, 3, ?, ?, ?, to_date(sysdate,'yyyy.mm.dd hh24:mi'))";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, C_user);
				psmt.setString(2, C_Comment);
				psmt.setString(3, C_Password);
								
				psmt.executeUpdate();
				
			}catch(Exception e) {
				
			}finally {
				try {
					if(psmt!=null)psmt.close();
					if(conn!=null)conn.close();
				}catch(Exception e) {}
			}
			
		}
		
		public List<CommentVO> selectAllComment(){
			List<CommentVO> list = new ArrayList<>();
			
			String sql = "SELECT * FROM Commenttbl";
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					CommentVO tVo = new CommentVO();
					tVo.setB_code(rs.getInt("b_code"));
					tVo.setC_code(rs.getInt("c_code"));
					tVo.setC_Comment(rs.getString("c_Comment"));
					tVo.setC_Password(rs.getString("c_Password"));
					tVo.setC_user(rs.getString("c_user"));
					tVo.setC_regDate(rs.getTimestamp("c_regDate"));
					
					list.add(tVo);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, stmt, rs);
			}
			return list;
		}
		
		
}
