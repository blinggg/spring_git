package com.example.domain;

public class CouVO extends ProVO{
	private String lcode;
	private String lname;
	private String instructor;
	private String room;
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
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "CouVO [lcode=" + lcode + ", lname=" + lname + ", instructor=" + instructor + ", room=" + room
				+ ", getPcode()=" + getPcode() + ", getPname()=" + getPname() + "]";
	}
	
	
}
