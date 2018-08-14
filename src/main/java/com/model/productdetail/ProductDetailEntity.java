package com.model.productdetail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.config.BaseEntity;
import com.model.amanity.AmanityEntity;
import com.model.image.ImageEntity;
import com.model.product.ProductEntity;
import com.model.review.ReviewEntity;

@Entity
@Table(name = "PRODUCT_DETAIL")
public class ProductDetailEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "RATING", nullable = false)
	private Double rating;

	@Column(name = "SLEEPS", nullable = false)
	private Integer sleeps;

	@Column(name = "BEDROOMS", nullable = false)
	private Integer bedrooms;

	@Column(name = "BATHROOMS", nullable = false)
	private Integer bathrooms;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productDetail", fetch = FetchType.LAZY)
	private List<AmanityEntity> amanities = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productDetail", fetch = FetchType.LAZY)
	private List<ReviewEntity> reviews = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productDetail", fetch = FetchType.LAZY)
	private List<ImageEntity> images = new ArrayList<>();
	
	@OneToOne(optional = false)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private ProductEntity product;

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

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
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

	public void addAmanity(AmanityEntity amanity) {
		amanities.add(amanity);
		amanity.setProductDetail(this);
	}

	public void removeAmanity(AmanityEntity amanity) {
		amanities.remove(amanity);
		amanity.setProductDetail(null);
	}

	public AmanityEntity[] getAmanities() {
		return amanities.toArray(new AmanityEntity[amanities.size()]);
	}

	public void addImages(ImageEntity image) {
		images.add(image);
		image.setProductDetail(this);
	}

	public void removeImages(ImageEntity image) {
		images.remove(image);
		image.setProductDetail(null);
	}

	public ImageEntity[] getImages() {
		return images.toArray(new ImageEntity[images.size()]);
	}

	public void addReview(ReviewEntity review) {
		reviews.add(review);
		review.setProductDetail(this);
	}

	public void removeReview(ReviewEntity review) {
		reviews.remove(review);
		review.setProductDetail(null);
	}

	public ReviewEntity[] getReviews() {
		return reviews.toArray(new ReviewEntity[reviews.size()]);
	}

	public void setAmanities(List<AmanityEntity> amanities) {
		this.amanities = amanities;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

	public void setImages(List<ImageEntity> images) {
		this.images = images;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductDetailEntity [id=" + getId() + ", address=" + address + ", rating=" + rating + ", sleeps="
				+ sleeps + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", description=" + description + "]";
	}

}