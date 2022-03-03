package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.BoardVO;

public class BoardDAO {
	// DAO는 싱글턴 패턴으로 제작
	private BoardDAO(){}
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	
	/////////////////////////////////////////////////
	// 모든 게시물 조회
	public List<BoardVO> selectAllBoard(){
		List<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM board ORDER BY num DESC";// 가장 최신 글이 상단에 보이도록
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(bVo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	////////////////////////////////////////////////////////////////////////
	// 게시물 등록 기능
	public void insertBoard(BoardVO bVo) {
		String sql = "INSERT INTO board (num,name,pass,email,title,content) " + 
				" VALUES(board_seq.nextval,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bVo.getName());
			psmt.setString(2, bVo.getPass());
			psmt.setString(3, bVo.getEmail());
			psmt.setString(4, bVo.getTitle());
			psmt.setString(5, bVo.getContent());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// 게시물 조회시 카운트 증가 메서드
	public void updateReadCount(String num) {
		String sql="UPDATE board SET readcount=readcount+1 WHERE num=?";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,num);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// 게시물 상세보기를 위한 조회 메서드
	public BoardVO selectBoardByNum(String num) {
		BoardVO bVo = null;
		
		String sql = "SELECT * FROM board WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}

		return bVo;
	}
	
	/////////////////////////////////////////////////////////////////////
	// 암호 확인 메서드
	public boolean checkPassword(String num, String pass) {
		BoardVO bVo = selectBoardByNum(num);
		
		if(bVo.getPass().equals(pass)) {
			return true;   //암호 일치
		}else {
			return false;	// 암호 불일치
		}
	}
	
	
	////////////////////////////////////////////////////////////////////
	// 게시물 삭제
	public void deleteBoard(String num) {
		String sql = "DELETE FROM board WHERE num=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, num);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	//////////////////////////////////////////////////////////////////////
	// 게시물 수정
	public void updateBoard(BoardVO bVo) {
		String sql="UPDATE board SET name=?, email=?, pass=?, title=?, content=? WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,bVo.getName());
			psmt.setString(2,bVo.getEmail());
			psmt.setString(3,bVo.getPass());
			psmt.setString(4,bVo.getTitle());
			psmt.setString(5,bVo.getContent());
			psmt.setInt(6,bVo.getNum());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////
	// 전체 게시글 수를 알아오는 쿼리
	public int selectAllNumBoard() {
		int cntAll=0;
		
		String sql = "SELECT COUNT(*) FROM board";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				cntAll = rs.getInt(1);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return cntAll;

	}
	
	/////////////////////////////////////////////////////////////////////////////
	// 현재 페이지 정보(섹션번호, 페이지 번호) 현재 페이지 글목록읽어오기
	
	public List<BoardVO> selectTargetBoard(int section, int pageNum){
		List<BoardVO> list = new ArrayList<>();
	
		String sql = " SELECT * FROM "
				+ " (SELECT ROWNUM as nick ,num, name, email, pass, title, content, readcount, writedate "  
				+ " FROM (SELECT * FROM board ORDER BY num DESC)) "  
				+ " WHERE nick BETWEEN (?-1)*100+(?-1)*10+1 AND (?-1)*100+(?)*10";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, section);
			psmt.setInt(2, pageNum);
			psmt.setInt(3, section);
			psmt.setInt(4, pageNum);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(bVo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	

}
