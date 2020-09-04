package com.example.domain;

public class ChartVO {
	private String name;
	private Double value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ChartVO [name=" + name + ", value=" + value + "]";
	}
}
