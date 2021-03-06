package com.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.config.BaseEntity;
import com.model.productdetail.ProductDetailEntity;

@Entity
@Table(name = "PRODUCT")
@NamedQueries({
		@NamedQuery(name = ProductEntity.FIND_BY_NAME, query = "SELECT product FROM ProductEntity product "
				+ " WHERE product.name LIKE :name"),
		@NamedQuery(name = ProductEntity.GET_ALL_PRODUCT_NAMES, query = "SELECT product.name FROM ProductEntity product"),
		@NamedQuery(name = ProductEntity.SORTED_ALL_PRODUCTS_BY_NAMES, query = "SELECT product FROM ProductEntity product "
				+ "ORDER BY product.name") })
public class ProductEntity extends BaseEntity {

	public static final String SORTED_ALL_PRODUCTS_BY_NAMES ="ProductEntity.sortedByName";

	public static final String FIND_BY_NAME = "ProductEntity.findByName";

	public static final String GET_ALL_PRODUCT_NAMES = "ProductEntity.getAllProductNames";

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "PRICE", nullable = false)
	private Long price;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false)
	private ProductTypeEntity type;

	@Column(name = "AREA", nullable = false)
	private Integer area;

	@Column(name = "LOCATION", nullable = false)
	private String location;

	@Column(name = "IMAGE")
	private byte[] image;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
	private ProductDetailEntity productDetail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public ProductTypeEntity getType() {
		return type;
	}

	public void setType(ProductTypeEntity type) {
		this.type = type;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ProductDetailEntity getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetailEntity productDetail) {
		this.productDetail = productDetail;
		productDetail.setProduct(this);
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + getId() + ", name=" + name + ", price=" + price + ", type=" + type.name()
				+ ", area=" + area + ", location=" + location + "]";
	}

}
