package com.model.amanity;

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
@Table(name = "AMANITY")
public class AmanityEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "NAME", nullable = false)
	private AmanityTypeEntity name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PRODUCT_DETAIL_ID", nullable = false)
	private ProductDetailEntity productDetail;

	public AmanityTypeEntity getName() {
		return name;
	}

	public void setName(AmanityTypeEntity name) {
		this.name = name;
	}

	public void setProductDetail(ProductDetailEntity productDetail) {
		this.productDetail = productDetail;
	}

	@Override
	public String toString() {
		return "AmanityEntity [id=" + getId() + ", name=" + name + "]";
	}

}
