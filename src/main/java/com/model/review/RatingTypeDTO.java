package com.model.review;

public enum RatingTypeDTO {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), ZERO(0);

	private int value;

	private RatingTypeDTO(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
