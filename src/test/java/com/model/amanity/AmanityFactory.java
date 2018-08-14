package com.model.amanity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public final class AmanityFactory {
	public static List<AmanityEntity> generateRandomAmanityEntities(int size) {
		List<AmanityEntity> entities = new ArrayList<AmanityEntity>();
		for (int i = 0; i < size; i++) {
			entities.add(generateRandomAmanityEntity());
		}
		return entities;
	}

	public static List<AmanityDTO> generateRandomAmanityDtos(int size) {
		List<AmanityDTO> dtos = new ArrayList<AmanityDTO>();
		for (int i = 0; i < size; i++) {
			dtos.add(generateRandomAmanityDTO());
		}
		return dtos;
	}

	public static AmanityEntity generateRandomAmanityEntity() {
		return generateRandomAmanityEntity(RandomUtils.nextInt());
	}

	public static AmanityEntity generateRandomAmanityEntity(Integer id) {
		AmanityEntity entity = new AmanityEntity();
		entity.setId(id);
		entity.setName(generateRandomAmanityTypeEntity());

		return entity;
	}

	public static AmanityDTO generateRandomAmanityDTO() {
		AmanityDTO dto = new AmanityDTO();
		dto.setId(RandomUtils.nextInt());
		dto.setName(generateRandomAmanityTypeDTO());

		return dto;

	}

	public static AmanityTypeEntity generateRandomAmanityTypeEntity() {
		return AmanityTypeEntity.values()[RandomUtils.nextInt(0, AmanityTypeEntity.values().length)];
	}

	public static AmanityTypeDTO generateRandomAmanityTypeDTO() {
		return AmanityTypeDTO.values()[RandomUtils.nextInt(0, AmanityTypeDTO.values().length)];
	}

}
