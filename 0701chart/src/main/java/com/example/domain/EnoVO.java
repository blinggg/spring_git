package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EnoVO {
	private String lcode;
	private String scode;
	@JsonFormat(pattern="yyyy-MM-dd",timezone ="Asia/Seoul")
	private Date edate;
	private int grade;
	private String sname;
	private String lname;
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "EnoVO [lcode=" + lcode + ", scode=" + scode + ", edate=" + edate + ", grade=" + grade + ", sname="
				+ sname + ", lname=" + lname + "]";
	}
	 
}
