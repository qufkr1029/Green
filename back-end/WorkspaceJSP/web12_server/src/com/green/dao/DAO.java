package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.CourseVO;
import com.green.vo.JoinVO;
import com.green.vo.LecturerVO;
import com.sun.net.httpserver.Authenticator.Result;


public class DAO {
	//DAO 싱글턴 제작
	private DAO() {}
	private static DAO dao = new DAO();
	public static DAO getInstance() {
		return dao;
	}
	
	public int countCourse() {
			// 교과목이 몇개인지 세는 기능
		int cnt = 0;
		
		String sql = "select count(*) as cnt from course_tbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt("cnt");			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return cnt;		
	}
	
	public int countlecturer() {
		// 강사가 몇 명인지 세는 기능
	int cnt = 0;
	
	String sql = "select count(*) as cnt from lecturer_tbl";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			cnt = rs.getInt("cnt");			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(conn, stmt, rs);
	}
	
	return cnt;		
}
	
	public List<JoinVO> selectAllJoin(){
				 // 조인한 교과목 데베 조회기능
		
		List<JoinVO> list = new ArrayList<>();
		
		// 다른 두개의 테이블을 조인하여 교과목 아이디 내림차순으로 정렬해서 조회
		String sql = "select id, c.name, credit, l.name as l_name, week from course_tbl c, lecturer_tbl l where lecturer = idx order by id asc ";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				JoinVO jVo = new JoinVO();
				
				jVo.setId(rs.getString("id"));
				jVo.setName(rs.getString("name"));
				jVo.setCredit(rs.getInt("credit"));
				jVo.setL_name(rs.getString("l_name"));
				jVo.setWeek(rs.getInt("week"));
				
				list.add(jVo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<CourseVO> selectAllCourse() {
		// 강사 데이터베이스 조회 기능
		
				List<CourseVO> list = new ArrayList<>();
				
				String sql = "select * from course_tbl order by id asc";
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try {
					conn = DBManager.getConnection();
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						CourseVO cVo = new CourseVO();
						
						cVo.setId(rs.getString("id"));
						cVo.setName(rs.getString("name"));
						cVo.setCredit(rs.getInt("credit"));
						cVo.setLecturer(rs.getInt("lecturer"));
						cVo.setWeek(rs.getInt("week"));
						cVo.setStart_hour(rs.getInt("start_hour"));
						cVo.setEnd_hour(rs.getInt("end_hour"));
						
						list.add(cVo);
					}

				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, stmt, rs);
				}
				return list;
	}
	
	public List<LecturerVO> selectAllLecturer() {
					// 강사 데이터베이스 조회 기능
		
		List<LecturerVO> list = new ArrayList<>();
		
		String sql = "select * from lecturer_tbl order by name asc";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LecturerVO lVo = new LecturerVO();
				
				lVo.setIdx(rs.getInt("idx"));
				lVo.setName(rs.getString("name"));
				lVo.setMajor(rs.getString("major"));
				lVo.setField(rs.getString("field"));
				
				list.add(lVo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
		
	}

	public void insertCourse(CourseVO cVo) {
		      // 교과목을 등록하는 기능
		
		String sql = "INSERT INTO course_tbl (id,name,lecturer,credit,week,start_hour,end_hour)" + 
				" VALUES(?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getLecturer());
			psmt.setInt(4, cVo.getCredit());
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public JoinVO selectJoinByID(String id) {
		         // 가져온 id값을 토대로 데이터베이스 조회
		JoinVO jVo = null;

		String sql = "select c.id, c.name, l.name as l_name, c.credit, c.week, c.start_hour, c.end_hour from course_tbl c, lecturer_tbl l where c.lecturer = l.idx and id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);			
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				jVo = new JoinVO();
				
				jVo.setId(rs.getString("id"));
				jVo.setName(rs.getString("name"));
				jVo.setL_name(rs.getString("l_name"));
				jVo.setCredit(rs.getInt("credit"));
				jVo.setWeek(rs.getInt("week"));
				jVo.setStart_hour(rs.getInt("start_hour"));
				jVo.setEnd_hour(rs.getInt("end_hour"));			
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}

		return jVo;
	}

	public void deleteCourse(String id) {
		//		 교과목을 삭제하는 메서드
		String sql = "delete from course_tbl where id=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public void updateCourse(CourseVO cVo) {
		// 		교과목을 업데이트 하는 메서드
		String sql = "update course_tbl set id=?,name=?,credit=?,lecturer=?,week=?,start_hour=?,end_hour=? where id =?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, cVo.getLecturer());
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			psmt.setString(8, cVo.getId());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public void insertLecturer(LecturerVO lVo) {
		// 교과목을 등록(생성)하는 기능
		
		String sql = "INSERT INTO lecturer_tbl (idx, name, major, field) " + 
				" VALUES(lecturer_tbl_seq.nextval,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setString(1, lVo.getName());
			psmt.setString(2, lVo.getMajor());
			psmt.setString(3, lVo.getField());

			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public LecturerVO selectByIDX(String idx) {
		// 가져온 idx값을 토대로 데이터베이스 조회
		LecturerVO lVo = null;

		String sql = "select * from lecturer_tbl where idx=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);			
			
			psmt.setString(1, idx);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				lVo = new LecturerVO();
				
				lVo.setIdx(rs.getInt("idx"));
				lVo.setName(rs.getString("name"));
				lVo.setMajor(rs.getString("major"));
				lVo.setField(rs.getString("field"));
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}

		return lVo;
	}

	public void updateLecturer(LecturerVO lVo) {
		// 		강사 정보를 업데이트 하는 메서드
		String sql = "update lecturer_tbl set name=?, major=?,field=? id =?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lVo.getName());
			psmt.setString(2, lVo.getMajor());
			psmt.setString(3, lVo.getField());
			psmt.setInt(4, lVo.getIdx());
			
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}
	
}
