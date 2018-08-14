package com.model.productdetail;

import java.io.Serializable;
import java.util.List;

import com.model.amanity.AmanityDTO;
import com.model.image.ImageDTO;
import com.model.review.ReviewDTO;

public class ProductDetailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String address;

	private Double rating;

	private Integer sleeps;

	private Integer badrooms;

	private Integer bathrooms;

	private String description;

	private List<AmanityDTO> amanities;

	private List<ReviewDTO> reviews;

	private List<ImageDTO> images;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getSleeps() {
		return sleeps;
	}

	public void setSleeps(Integer sleeps) {
		this.sleeps = sleeps;
	}

	public Integer getBadrooms() {
		return badrooms;
	}

	public void setBadrooms(Integer badrooms) {
		this.badrooms = badrooms;
	}

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AmanityDTO> getAmanities() {
		return amanities;
	}

	public void setAmanities(List<AmanityDTO> amanities) {
		this.amanities = amanities;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "ProductDTO" + " [id=" + getId() + ", address=" + address + ", rating=" + rating + ", sleeps=" + sleeps
				+ ", badrooms=" + badrooms + ", bathrooms=" + bathrooms + ", description=" + description
				+ ", amanities=" + amanities + ", reviews=" + reviews + ", images=" + images + "]";
	}
}
