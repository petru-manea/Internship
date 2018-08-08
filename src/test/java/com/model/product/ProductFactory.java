package com.model.product;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public final class ProductFactory {

	public static ProductEntity generateRandomProductEntity() {
		ProductEntity entity = new ProductEntity();
		entity.setId(RandomUtils.nextInt());
		entity.setName(RandomStringUtils.randomAlphabetic(10));
		entity.setPrice(RandomUtils.nextLong());
		entity.setType(ProductTypeEntity.values()[RandomUtils.nextInt(0, 4)]);
		entity.setArea(RandomUtils.nextInt());
		entity.setLocation(RandomStringUtils.randomAlphabetic(20));

		byte[] bytes = generateRandomByteArray(RandomUtils.nextInt(10, 100));

		entity.setImage(bytes);
		return entity;
	}

	public static ProductDTO generateRandomProductDTO() {
		ProductDTO dto = new ProductDTO();
		dto.setId(RandomUtils.nextInt());
		dto.setName(RandomStringUtils.randomAlphabetic(10));
		dto.setPrice(RandomUtils.nextLong());
		dto.setType(ProductTypeDTO.values()[RandomUtils.nextInt(0, 4)]);
		dto.setArea(RandomUtils.nextInt());
		dto.setLocation(RandomStringUtils.randomAlphabetic(20));

		byte[] bytes = generateRandomByteArray(RandomUtils.nextInt(10, 100));

		dto.setImage(bytes);
		return dto;
	}

	public static ProductTypeEntity generateRandomProductTypeEntity() {
		return ProductTypeEntity.values()[RandomUtils.nextInt(0, ProductTypeEntity.values().length)];
	}

	public static ProductTypeDTO generateRandomProductTypeDTO() {
		return ProductTypeDTO.values()[RandomUtils.nextInt(0, ProductTypeDTO.values().length )];
	}

	public static byte[] generateRandomByteArray(int size) {
		byte[] bytes = new byte[size];
		new Random().nextBytes(bytes);
		return bytes;
	}
}
