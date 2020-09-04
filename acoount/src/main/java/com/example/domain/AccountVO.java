package com.example.domain;

import java.util.Date;

public class AccountVO extends UserVO{
	private String ano;
	private String id;
	private Date openDate;
	private Double balance;
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AcoountVO [ano=" + ano + ", id=" + id + ", openDate=" + openDate + ", balance=" + balance
				+ ", getPass()=" + getPass() + ", getName()=" + getName() + ", getPoint()=" + getPoint() + "]";
	}
	
	
	
}
