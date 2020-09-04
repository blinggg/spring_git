package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TradeVO extends UserVO{
	private int tid;
	private String ano;
	private String type;
	private String tradeNo;
	private Double amount;
	@JsonFormat(pattern="yyyy-MM-dd kk:mm:ss", timezone="Asia/Seoul")
	private Date tradeDate;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	@Override
	public String toString() {
		return "TradeVO [tid=" + tid + ", ano=" + ano + ", type=" + type + ", tradeNo=" + tradeNo + ", amount=" + amount
				+ ", tradeDate=" + tradeDate + ", getId()=" + getId() + ", getPass()=" + getPass() + ", getName()="
				+ getName() + ", getPoint()=" + getPoint() + "]";
	}

	
	
}
