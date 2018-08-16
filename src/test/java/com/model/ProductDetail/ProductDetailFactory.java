package com.model.ProductDetail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import com.model.amanity.AmanityFactory;
import com.model.image.ImageFactory;
import com.model.productdetail.ProductDetailDTO;
import com.model.productdetail.ProductDetailEntity;
import com.model.review.ReviewFactory;

public class ProductDetailFactory {

	public static List<ProductDetailEntity> generateRandomProductDetailEntities(int size) {
		List<ProductDetailEntity> entities = new ArrayList<ProductDetailEntity>();
		for (int i = 0; i < size; i++) {
			entities.add(generateRandomProductDetailEntity());
		}
		return entities;
	}

	public static List<ProductDetailDTO> generateRandomProductDetailDtos(int size) {
		List<ProductDetailDTO> dtos = new ArrayList<ProductDetailDTO>();
		for (int i = 0; i < size; i++) {
			dtos.add(generateRandomProductDetailDTO());
		}
		return dtos;
	}

	public static ProductDetailEntity generateRandomProductDetailEntity() {
		return generateRandomProductDetailEntity(RandomUtils.nextInt());
	}

	public static ProductDetailEntity generateRandomProductDetailEntity(Integer id) {
		ProductDetailEntity entity = new ProductDetailEntity();
		entity.setId(id);
		entity.setAddress(RandomStringUtils.randomAlphabetic(10));
		entity.setRating(RandomUtils.nextDouble());
		entity.setSleeps(RandomUtils.nextInt());
		entity.setBedrooms(RandomUtils.nextInt());
		entity.setBathrooms(RandomUtils.nextInt());
		entity.setDescription(RandomStringUtils.randomAlphabetic(10));
		entity.setAmanities(AmanityFactory.generateRandomAmanityEntities(2));
		entity.setImages(ImageFactory.generateRandomImageEntities(2));
		entity.setReviews(ReviewFactory.generateRandomReviewEntities(2));
		return entity;
	}

	public static ProductDetailDTO generateRandomProductDetailDTO() {
		ProductDetailDTO dto = new ProductDetailDTO();
		dto.setId(RandomUtils.nextInt());
		dto.setAddress(RandomStringUtils.randomAlphabetic(10));
		dto.setRating(RandomUtils.nextDouble());
		dto.setSleeps(RandomUtils.nextInt());
		dto.setBedrooms(RandomUtils.nextInt());
		dto.setBathrooms(RandomUtils.nextInt());
		dto.setDescription(RandomStringUtils.randomAlphabetic(10));
		dto.setAmanities(AmanityFactory.generateRandomAmanityDtos(2));
		dto.setImages(ImageFactory.generateRandomImageDtos(2));
		dto.setReviews(ReviewFactory.generateRandomReviewDtos(2));

		return dto;
	}

}
