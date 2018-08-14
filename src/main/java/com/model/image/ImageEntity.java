package com.model.image;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.config.BaseEntity;
import com.model.productdetail.ProductDetailEntity;

@Entity
@Table(name = "IMAGES")
public class ImageEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PRODUCT_DETAIL_ID", nullable = false)
	private ProductDetailEntity productDetail;

	@Column(name = "PICTURE")
	private byte[] picture;

	public void setProductDetail(ProductDetailEntity productDetail) {
		this.productDetail = productDetail;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "ImageEntity [id=" + getId() + ", picture=" + Arrays.toString(picture) + "]";
	}

}
