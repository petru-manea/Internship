package com.model.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import com.model.ProductDetail.ProductDetailFactory;

public final class ProductFactory {

//	public static List<String> generateRandomProductEntitiesSorted(int size) {
//		List<String> entities = new ArrayList<String>();
//		for (int i = 0; i < size; i++) {
//			entities.addAll(generateRandomProductEntity());
//		}
//		return entities;
//	}
	

	public static List<ProductEntity> generateRandomProductEntities(int size) {
		List<ProductEntity> entities = new ArrayList<ProductEntity>();
		for (int i = 0; i < size; i++) {
			entities.add(generateRandomProductEntity());
		}
		return entities;
	}

	public static List<ProductEntity> generateRandomProductEntities(int size, String name) {
		List<ProductEntity> entities = new ArrayList<ProductEntity>();
		for (int i = 0; i < size; i++) {
			entities.add(generateRandomProductEntity(name));
		}
		return entities;
	}

	public static List<ProductDTO> generateRandomProductDtos(int size) {
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for (int i = 0; i < size; i++) {
			dtos.add(generateRandomProductDTO());
		}
		return dtos;
	}

	public static ProductEntity generateRandomProductEntity() {
		return generateRandomProductEntity(RandomUtils.nextInt());
	}

	public static ProductEntity generateRandomProductEntity(Integer id) {
		ProductEntity entity = new ProductEntity();
		entity.setId(id);
		entity.setName(RandomStringUtils.randomAlphabetic(10));
		entity.setPrice(RandomUtils.nextLong());
		entity.setType(ProductTypeEntity.values()[RandomUtils.nextInt(0, 4)]);
		entity.setArea(RandomUtils.nextInt());
		entity.setLocation(RandomStringUtils.randomAlphabetic(20));

		byte[] bytes = generateRandomByteArray(RandomUtils.nextInt(10, 100));

		entity.setImage(bytes);

		entity.setProductDetail(ProductDetailFactory.generateRandomProductDetailEntity());

		return entity;
	}

	public static ProductEntity generateRandomProductEntity(String name) {
		ProductEntity entity = new ProductEntity();
		entity.setId(RandomUtils.nextInt());
		entity.setName(name + RandomStringUtils.randomAlphabetic(10));
		entity.setPrice(RandomUtils.nextLong());
		entity.setType(ProductTypeEntity.values()[RandomUtils.nextInt(0, 4)]);
		entity.setArea(RandomUtils.nextInt());
		entity.setLocation(RandomStringUtils.randomAlphabetic(20));

		byte[] bytes = generateRandomByteArray(RandomUtils.nextInt(10, 100));

		entity.setImage(bytes);

		entity.setProductDetail(ProductDetailFactory.generateRandomProductDetailEntity());

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

		dto.setProductDetail(ProductDetailFactory.generateRandomProductDetailDTO());

		return dto;
	}

	public static ProductTypeEntity generateRandomProductTypeEntity() {
		return ProductTypeEntity.values()[RandomUtils.nextInt(0, ProductTypeEntity.values().length)];
	}

	public static ProductTypeDTO generateRandomProductTypeDTO() {
		return ProductTypeDTO.values()[RandomUtils.nextInt(0, ProductTypeDTO.values().length)];
	}

	public static byte[] generateRandomByteArray(int size) {
		byte[] bytes = new byte[size];
		new Random().nextBytes(bytes);
		return bytes;
	}
}
