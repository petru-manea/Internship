package com.model.image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

public class ImageFactory {

	
	public static List<ImageEntity> generateRandomImageEntities(int size){
		List<ImageEntity> entities = new ArrayList<ImageEntity>();
		for(int i=0; i<size; i++){
			entities.add(generateRandomImageEntity());
		}
		return entities;
	}
	
	public static List<ImageDTO> generateRandomImageDtos(int size){
		List<ImageDTO> dtos = new ArrayList<ImageDTO>();
		for(int i=0; i<size; i++){
			dtos.add(generateRandomImageDTO());
		}
		return dtos;
	}
	
	public static ImageEntity generateRandomImageEntity(){
		return generateRandomImageEntity(RandomUtils.nextInt());
	}
	
	public static ImageEntity generateRandomImageEntity(Integer id) {
		ImageEntity entity = new ImageEntity();
		entity.setId(id);

		byte[] bytes = generateRandomByteArray(RandomUtils.nextInt(10, 100));

		entity.setPicture(bytes);
		return entity;
	}

	public static ImageDTO generateRandomImageDTO() {
		ImageDTO dto = new ImageDTO();
		dto.setId(RandomUtils.nextInt());
		
		byte[] bytes = generateRandomByteArray(RandomUtils.nextInt(10, 100));

		dto.setPicture(bytes);
		return dto;
	}

	public static byte[] generateRandomByteArray(int size) {
		byte[] bytes = new byte[size];
		new Random().nextBytes(bytes);
		return bytes;
	}
}
