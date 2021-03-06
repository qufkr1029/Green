package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.mapper.MapperSQLToMember;
import spring.vo.Member;

public class MemberDao { 
	// 쿼리를 실행시킬 때 필요한 정보 => 연결객체, 쿼리, 결과를 받아줄 리스트,(?를 채우기 위한 매개값)
	
	// jdbcTemplete 이라는 객체를 이용해서 DB연결 제어  => .query();

	private JdbcTemplate jdbcTemplate;
	//private MapperSQLToMember mapper= new MapperSQLToMember();
	//private RowMapper<Member> mapper= new MapperSQLToMember();
	private RowMapper<Member> mapper= new RowMapper<Member>() {//익명 구현 객체

				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("email"),
								rs.getString("password"),
								rs.getString("name"),
								rs.getTimestamp("regdate"));
						member.setId(rs.getLong("id"));
					return member;
				}   
		
		};
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Member> selectAll() {
		String sql = "SELECT * FROM members ORDER BY id ASC";
		
		//List<Member> list= jdbcTemplate.query(sql, new MapperSQLToMember() );
//		List<Member> list= jdbcTemplate.query(sql, mapper );
//		List<Member> list= jdbcTemplate.query(sql, new RowMapper<Member>() {
//
//						@Override
//						public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//							Member member = new Member(
//									rs.getString("email"),
//									rs.getString("password"),
//									rs.getString("name"),
//									rs.getTimestamp("regdate"));
//							member.setId(rs.getLong("id"));
//						return member;
//						}
//			
//				});
		
		List<Member> list= jdbcTemplate.query(sql, (rs,rowNum)->{
									Member member = new Member(
											rs.getString("email"),
											rs.getString("password"),
											rs.getString("name"),
											rs.getTimestamp("regdate"));
									member.setId(rs.getLong("id"));
								return member;
						});
		
		return list;
	}
	
	
	
	public Member selectByEmail(String email) {
		return null;
	}
	
	public void insert(Member member) {
		
	}
	
	public void update(Member member) {
		
	}
	
	
}
