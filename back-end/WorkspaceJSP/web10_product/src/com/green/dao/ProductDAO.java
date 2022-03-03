package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.ProductVO;

import oracle.jdbc.proxy.annotation.Pre;

public class ProductDAO {
	//  싱글턴 패턴
	private ProductDAO() {}
	private static ProductDAO dao = new ProductDAO();
	public static ProductDAO getInstance() {
		return dao;
	}
	
	//------------------------------------------------
	// 연결 객체를 얻어오기 위한 메서드
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 연결을 해제하기 위한 메서드
	// 1) select를 위한 해제
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 2) insert,update,delete 를 위한 해제
	public void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//-------------------------------------------------------
	// 전체 데이터를 읽어오는 메서드
	public List<ProductVO> selectAllProduct(){
		List<ProductVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM producttbl ORDER BY code DESC";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				
				list.add(pVo);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		return list;
	}
	//---------------------------------------------------------------------
	// 상품 등록 기능을 담당하는 메서드
	public void insertProduct(ProductVO pVo) {
		String sql = "INSERT INTO producttbl VALUES(PRODUCT_SEQ.nextval,?,?,?,?)";
	
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pVo.getName());
			psmt.setInt(2, pVo.getPrice());
			psmt.setString(3, pVo.getPictureurl());
			psmt.setString(4, pVo.getDescription());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt);
		}
	
	}
	
	//----------------------------------------------------------------
	// 상품 삭제 기능을 담당하는 메서드 => 코드값을 통해 상품 삭제
	public void deleteProduct(int code) {
		String sql = "DELETE FROM producttbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		//Statement stmt
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			// stmt = conn.createStatment();
			
			psmt.setInt(1,code);
			
			psmt.executeUpdate();
			//stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt);
		}
	}
	//----------------------------------------------------------------------------
	// 상품 상세 보기를 위해 상품 정보를 읽어오는 메서드
	public ProductVO selectProductByCode(int code) {
		ProductVO pVo=null;
		
		String sql = "SELECT * FROM producttbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null; 
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, code);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				pVo = new ProductVO();
				
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		return pVo;
	}
	// 상품 정보 갱신하는 기능을 담당하는 메서드
	public void updateProduct(ProductVO pVo) {
		
		String sql = "UPDATE producttbl SET name=?, price=?, pictureurl=?, description=? WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,pVo.getName());
			psmt.setInt(2,pVo.getPrice());
			psmt.setString(3,pVo.getPictureurl());
			psmt.setString(4,pVo.getDescription());
			psmt.setInt(5,pVo.getCode());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
