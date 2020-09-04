package com.example.domain;

public class ProVO {
	private String pcode;
	private String pname;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "ProVO [pcode=" + pcode + ", pname=" + pname + "]";
	}
	
	
}
