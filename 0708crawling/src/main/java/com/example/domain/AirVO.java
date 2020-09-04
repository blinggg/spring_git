package com.example.domain;

public class AirVO {
	private String title;
	private String image;
	private String info;
	private String city;
	private String rating;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "AirVO [title=" + title + ", image=" + image + ", info=" + info + ", city=" + city + ", rating=" + rating
				+ "]";
	}
	
}
