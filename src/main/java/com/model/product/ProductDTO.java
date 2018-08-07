package com.model.product;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Long price;

	private ProductTypeDTO type;

	private Integer area;

	private String location;

	private byte[] image;

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

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + ", type=" + type.getName() + ", area=" + area + ", location="
				+ location + ", image=" + image.length + "]";
	}
}
