package com.model.product;

import java.io.Serializable;
import java.util.Arrays;

import com.model.productdetail.ProductDetailDTO;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Long price;

	private ProductTypeDTO type;

	private Integer area;

	private String location;

	private byte[] image;
	
	private ProductDetailDTO productDetail;

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public ProductTypeDTO getType() {
		return type;
	}

	public void setType(ProductTypeDTO type) {
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


	public ProductDetailDTO getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetailDTO productDetail) {
		this.productDetail = productDetail;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + ", area=" + area
				+ ", location=" + location + ", image=" + Arrays.toString(image) + ", productDetail=" + productDetail
				+ "]";
	}
	

}
