package model.product;

public enum ProductTypeDTO {

	HOUSE("House"),
	VILLA("Villa"),
	APARTMENT("Apartment"),
	HOTEL("Hotel");
	
	private String name;
	
	private ProductTypeDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
