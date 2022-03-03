package com.green.vo;

import java.sql.Timestamp;

public class CommentVO {
	private int C_code; // 댓글코드
	private int B_code;	// 게시글 코드
	private String C_user; // 작성자
	private String C_Comment; // 내용
	private String C_Password; // 비밀번호
	private Timestamp C_regDate; //작성일
	
	public int getC_code() {
		return C_code;
	}
	public void setC_code(int c_code) {
		C_code = c_code;
	}
	public int getB_code() {
		return B_code;
	}
	public void setB_code(int b_code) {
		B_code = b_code;
	}
	public String getC_user() {
		return C_user;
	}
	public void setC_user(String c_user) {
		C_user = c_user;
	}
	public String getC_Comment() {
		return C_Comment;
	}
	public void setC_Comment(String c_Comment) {
		C_Comment = c_Comment;
	}
	public String getC_Password() {
		return C_Password;
	}
	public void setC_Password(String c_Password) {
		C_Password = c_Password;
	}
	public Timestamp getC_regDate() {
		return C_regDate;
	}
	public void setC_regDate(Timestamp c_regDate) {
		C_regDate = c_regDate;
	}
	
	
}
