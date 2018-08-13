package com.model.image;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
	
	public List<ImageDTO> mapEntitiesToDto(List<ImageEntity> entities){
		if(entities == null){
			return null;
		}
		
		List<ImageDTO> dtos = new ArrayList<>();
		for(ImageEntity entity : entities){
			dtos.add(mapEntityToDto(entity));
		}
		return dtos;
	}
	
	public List<ImageEntity> mapDtosToEntity(List<ImageDTO> dtos){
		if(dtos == null){
			return null;
		}
		List<ImageEntity> entities = new ArrayList<>();
		
		for(ImageDTO dto : dtos){
			entities.add(mapDtoToEntity(dto));
		}
		return entities;
	}
	
	public ImageDTO mapEntityToDto(ImageEntity entity){
		if(entity == null){
			return null;
		}
		
		ImageDTO dto = new ImageDTO();
		dto.setId(entity.getId());
		dto.setPicture(entity.getPicture());
		
		return dto;
	}
	
	public ImageEntity mapDtoToEntity(ImageDTO dto){
		if(dto == null){
			return null;
		}
		
		ImageEntity entity = new ImageEntity();
		entity.setId(dto.getId());
		entity.setPicture(dto.getPicture());
		
		return entity;
	}
	

}
