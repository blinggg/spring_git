package com.example.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EnrollVO {
	private String lcode;
	private String lname;
	private String scode;
	private String sname;
	@JsonFormat(pattern="yyyy-MM-dd",timezone ="Asia/Seoul")
	private Date edate;

	private int grade;
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	@Override
	public String toString() {
		return "EnrollVO [lcode=" + lcode + ", lname=" + lname + ", scode=" + scode + ", sname=" + sname + ", edate="
				+ edate + ", grade=" + grade + "]";
	}
	
	
	
	
}
