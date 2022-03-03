package com.green.dao;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.MovieVO;

public class MovieDAO {
	// DAO는 싱글턴 패턴으로 제작
	private MovieDAO(){}
	private static MovieDAO dao = new MovieDAO();
	public static MovieDAO getInstance() {
		return dao;
	}
	
	// 모든 게시물 조회
	public List<MovieVO> selectAllMovie(){
		List<MovieVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM favoritemovie ORDER BY code DESC";// 가장 최신 글이 상단에 보이도록
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MovieVO mVo = new MovieVO();
				
				mVo.setCode(rs.getInt("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setPrice(rs.getString("price"));
				mVo.setStar(rs.getInt("star"));
				
				list.add(mVo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertMovie(MovieVO mVo) {
		     // 영화 등록 메서드
		String sql = "INSERT INTO favoritemovie (code,title,director,actor,price,star)" + 
				" VALUES(favoritemovie_seq.nextval,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getTitle());
			psmt.setString(2, mVo.getDirector());
			psmt.setString(3, mVo.getActor());
			psmt.setString(4, mVo.getPrice());
			psmt.setInt(5, mVo.getStar());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public MovieVO selectMovieByCode(String code) {
		        // 영화 상세보기를 위한 조회 메서드
		MovieVO mVo = null;
		
		String sql = "select * from favoritemovie where code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				mVo = new MovieVO();
				
				mVo.setCode(rs.getInt("code"));
				mVo.setActor(rs.getString("actor"));
				mVo.setDirector(rs.getString("director"));
				mVo.setPrice(rs.getString("price"));
				mVo.setTitle(rs.getString("title"));
				mVo.setStar(rs.getInt("star"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return mVo;
	}

	public void updateBoard(MovieVO mVo) {
		     // 영화 수정하기 위한 메서드
		String sql="UPDATE favoritemovie SET title=?, actor=?, director=?, star=?, price=? WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,mVo.getTitle());
			psmt.setString(2,mVo.getActor());
			psmt.setString(3,mVo.getDirector());
			psmt.setInt(4,mVo.getStar());
			psmt.setString(5,mVo.getPrice());
			psmt.setInt(6,mVo.getCode());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}

	public void deleteBoard(String code) {
		     // 영화 삭제하기 위한 메서드
		String sql = "delete from favoritemovie where code=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, code);
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
		
	}
}
