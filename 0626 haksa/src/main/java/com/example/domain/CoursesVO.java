package com.example.domain;

public class CoursesVO {
	private String lcode;
	private String lname;
	private String instructor;
	private String pname;
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
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "CoursesVO [lcode=" + lcode + ", lname=" + lname + ", instructor=" + instructor + ", pname=" + pname
				+ ", getLcode()=" + getLcode() + ", getLname()=" + getLname() + ", getInstructor()=" + getInstructor()
				+ ", getPname()=" + getPname() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
