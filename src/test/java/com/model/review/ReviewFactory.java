package com.model.review;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public final class ReviewFactory {

	public static List<ReviewEntity> generateRandomReviewEntities(int size) {
		List<ReviewEntity> entities = new ArrayList<ReviewEntity>();
		for (int i = 0; i < size; i++) {
			entities.add(generateRandomReviewEntity());
		}
		return entities;
	}

	public static List<ReviewDTO> generateRandomReviewDtos(int size) {
		List<ReviewDTO> dtos = new ArrayList<ReviewDTO>();
		for (int i = 0; i < size; i++) {
			dtos.add(generateRandomReviewDTO());
		}
		return dtos;
	}

	public static ReviewEntity generateRandomReviewEntity() {
		return generateRandomReviewEntity(RandomUtils.nextInt());
	}

	public static ReviewEntity generateRandomReviewEntity(Integer id) {
		ReviewEntity entity = new ReviewEntity();
		entity.setId(id);
		entity.setName(RandomStringUtils.randomAlphabetic(10));
		entity.setRating(generateRandomReviewTypeEntity());
		entity.setDate(Calendar.getInstance().getTime());
		entity.setText(RandomStringUtils.randomAlphabetic(20));
		return entity;
	}

	public static ReviewDTO generateRandomReviewDTO() {
		ReviewDTO dto = new ReviewDTO();
		dto.setId(RandomUtils.nextInt());
		dto.setName(RandomStringUtils.randomAlphabetic(10));
		dto.setRating(generateRandomReviewTypeDTO());
		dto.setDate(Calendar.getInstance().getTime());
		dto.setText(RandomStringUtils.randomAlphabetic(20));
		return dto;

	}

	public static RatingTypeEntity generateRandomReviewTypeEntity() {
		return RatingTypeEntity.values()[RandomUtils.nextInt(0, RatingTypeEntity.values().length)];
	}

	public static RatingTypeDTO generateRandomReviewTypeDTO() {
		return RatingTypeDTO.values()[RandomUtils.nextInt(0, RatingTypeDTO.values().length)];
	}

}
