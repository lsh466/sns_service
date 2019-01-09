package com.sns.webservice;

import java.util.Date;

public class MemberVO {

	private String username;
	private String userid;
	private String useremail;
	private String userpw;
	private String Reg_date;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getReg_date() {
		return Reg_date;
	}
	public void setReg_date(String reg_date) {
		Reg_date = reg_date;
	}
}
