package com.example.domain;

public class SEnrollVO {
	private String lcode;
	private String lname;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "SEnrollVO [lcode=" + lcode + ", lname=" + lname + ", grade=" + grade + "]";
	}
	
	
}
