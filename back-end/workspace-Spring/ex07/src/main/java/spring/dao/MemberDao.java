package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.vo.Member;

public class MemberDao { 
	// 쿼리를 실행시켈 때 필요한 정보 => 연결객체, 쿼리, 결과를 받아줄 리스트, (?를 채우기 위한 매개값)
	
	// jdbcTemplate 이라는 객체를 이용해서 DB연결 제어 => .query(); 
	
	private JdbcTemplate jdbcTemplate;
	//private MapperSQLToMember mapper = new MapperSQLToMember();
	private RowMapper<Member> mapper = new RowMapper<Member>() {// 익명 구현 객체

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
	
	public List<Member> selectAll() {  // 중요한 점 : 1. 정보를 알아올 쿼리, 2. 정보를 옮겨담을 Mapper, 3. 정보를 담아줄 List 
		String sql = "select * from members order by id asc";
		
		//List<Member> list = jdbcTemplate.query(sql, new MapperSQLToMember() );
		List<Member> list = jdbcTemplate.query(sql, new RowMapper<Member>() {

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
			
		});
		
		
		return list;
	}
	
	
	public Member selectByEmail(String email) {
		
		List<Member> list = jdbcTemplate.query("select * from members where email =?", new RowMapper<Member>() {

					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("email"),
								rs.getString("password"),
								rs.getString("name"),
								rs.getTimestamp("regdate"));
						member.setId(rs.getLong("id"));
					
					return member;
					}}, email);
		return list.isEmpty()?null:list.get(0); // 없으면 null 있으면 리스트의 0번 반환(삼항연산, 컬렉션내용들)
	}
	
	
	public int count() {  // 결과값이 하나인 경우
		Integer cnt = jdbcTemplate.queryForObject(
				"select conut(*) from members", Integer.class);
		return cnt;
	}
	
	public void update(Member member) {
		//  DB에 정보를 삽입, 수정, 삭제 기능
		int cnt = jdbcTemplate.update("update members set name=?, password=? where email=?",
									member.getName(),
									member.getPassword(),
									member.getEmail());
		System.out.println("업데이트로 변경된 데이터의 개수 : " + cnt);
	}
	
// 기존의 인서트 기능
//	public void insert(Member member) {	
//		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
//							// 미완성의 쿼리를 수동으로 완성시키는 기능
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement psmt = con.prepareStatement(
//						"insert into members values(members_seq.nextval, ?, ?, ?, ?)");
//				
//				psmt.setString(1, member.getEmail());
//				psmt.setString(2, member.getPassword());
//				psmt.setString(3, member.getName());
//				psmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
//				return psmt;
//			}
//		});
//		
//		System.out.println("인서트로 삽입된 데이터의 개수 : "+cnt);
//	}
	
	public void insert(Member member) {	// 시퀀스의 값을 미리 알아오기 => KeyHolder
		KeyHolder keyholder = new GeneratedKeyHolder();
		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
							// 미완성의 쿼리를 수동으로 완성시키는 기능
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement psmt = con.prepareStatement(
						"insert into members values(members_seq.nextval, ?, ?, ?, ?)",new String[] {"id"});
				
				psmt.setString(1, member.getEmail());
				psmt.setString(2, member.getPassword());
				psmt.setString(3, member.getName());
				psmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				return psmt;
			}
		},keyholder);
		
		Number keyNum = keyholder.getKey();
		System.out.println("넣게될 시퀀스 값 : " + keyNum.longValue());
		
		System.out.println("인서트로 삽입된 데이터의 개수 : "+cnt);
	}
	
	
	
	
}
