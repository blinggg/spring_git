package com.example.domain;

public class UserVO {
	private String id;
	private String name;
	private String pass;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", pass=" + pass + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getPass()=" + getPass() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
