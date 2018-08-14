package com.model.review;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.config.BaseEntity;
import com.model.productdetail.ProductDetailEntity;

@Entity
@Table(name = "REVIEW")
public class ReviewEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PRODUCT_DETAIL_ID", nullable = false)
	private ProductDetailEntity productDetail;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "RATING", nullable = false)
	private RatingTypeEntity rating;

	@Column(name = "DATE", nullable = false)
	private Date date;

	@Column(name = "TEXT")
	private String text;

	public void setProductDetail(ProductDetailEntity productDetail) {
		this.productDetail = productDetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RatingTypeEntity getRating() {
		return rating;
	}

	public void setRating(RatingTypeEntity rating) {
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
		return "ReviewEntity [id=" + getId() + ", name=" + name + ", rating=" + rating + ", date=" + date + ", text="
				+ text + "]";
	}

}
