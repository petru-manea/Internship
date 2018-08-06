package model.product;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import config.BaseEntity;

@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

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

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type.name() + ", area=" + area
				+ ", location=" + location + ", image=" + image.length + "]";
	}

}
