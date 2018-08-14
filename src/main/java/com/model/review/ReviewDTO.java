package com.model.review;

import java.io.Serializable;
import java.util.Date;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private RatingTypeDTO rating;
	
	private Date date;
	
	private  String text;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RatingTypeDTO getRating() {
		return rating;
	}

	public void setRating(RatingTypeDTO rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + getId() + ", name=" + name + ", rating=" + rating + ", date=" + date + ", text=" + text+ "]";
	}
	
}
