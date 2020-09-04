package com.example.domain;

public class SumVO {
	private String name;
	private Double value;
	private Double value2;
	private Double value3;
	private Double value4;
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
	public Double getValue2() {
		return value2;
	}
	public void setValue2(Double value2) {
		this.value2 = value2;
	}
	public Double getValue3() {
		return value3;
	}
	public void setValue3(Double value3) {
		this.value3 = value3;
	}
	public Double getValue4() {
		return value4;
	}
	public void setValue4(Double value4) {
		this.value4 = value4;
	}
	@Override
	public String toString() {
		return "SumVO [name=" + name + ", value=" + value + ", value2=" + value2 + ", value3=" + value3 + ", value4="
				+ value4 + "]";
	}
	
	
}
