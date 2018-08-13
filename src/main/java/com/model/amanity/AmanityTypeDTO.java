package com.model.amanity;

public enum AmanityTypeDTO {
	
	COFFEE_MAKER("Coffe Maker"),
	COOKING_UTENSILS("Cooking Utensils"),
	ICE_MAKER("Ice Maker"),
	MICROWAVE("Microwave"),
	STOVE("Stove"),
	PLAYGROUND("Playground");
	
	private String name;
	
	private AmanityTypeDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
