package com.sns.webservice;

import java.util.Date;

public class MemberVO {
		
	private String User_name;
	private String User_id;
	private String User_email;
	private String User_pw;
	private Date Reg_date;
	
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getUser_email() {
		return User_email;
	}
	public void setUser_email(String user_email) {
		User_email = user_email;
	}
	public String getUser_pw() {
		return User_pw;
	}
	public void setUser_pw(String user_pw) {
		User_pw = user_pw;
	}
	public Date getReg_date() {
		return Reg_date;
	}
	public void setReg_date(Date reg_date) {
		Reg_date = reg_date;
	}
}
