package com.example.domain;

import java.util.List;

public class UserVO {
	private String id;
	private String pass;
	private String name;
	//대표이미지
	private String image;
	//첨부이미지
	private List<String> images;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pass=" + pass + ", name=" + name + ", image=" + image + ", images=" + images
				+ "]";
	}
	
	
}
