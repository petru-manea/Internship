package com.model.review;

public enum ReviewTypeDTO {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), ZERO(0);

	private int value;

	private ReviewTypeDTO(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
