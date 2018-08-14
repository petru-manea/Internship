package com.model.review;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

@Component
public class ReviewMapper {
	
	private static final BiMap<RatingTypeEntity, RatingTypeDTO> REVIEW_TYPE_MAPPER = new ImmutableBiMap.Builder<RatingTypeEntity, RatingTypeDTO>()
			.put(RatingTypeEntity.ONE, RatingTypeDTO.ONE)
			.put(RatingTypeEntity.TWO, RatingTypeDTO.TWO)
			.put(RatingTypeEntity.THREE, RatingTypeDTO.THREE)
			.put(RatingTypeEntity.FOUR, RatingTypeDTO.FOUR)
			.put(RatingTypeEntity.FIVE, RatingTypeDTO.FIVE)
			.put(RatingTypeEntity.ZERO, RatingTypeDTO.ZERO)
			.build();

	public List<ReviewDTO> mapEntitiesToDto(List<ReviewEntity> entities){
		if(entities == null){
			return null;
		}
		
		List<ReviewDTO> dtos = new ArrayList<>();
		for(ReviewEntity entity : entities){
			dtos.add(mapEntityToDto(entity));
		}
		return dtos;
	}
	
	public List<ReviewEntity> mapDtosToEntity(List<ReviewDTO> dtos){
		if(dtos == null){
			return null;
		}
		List<ReviewEntity> entities = new ArrayList<>();
		
		for(ReviewDTO dto : dtos){
			entities.add(mapDtoToEntity(dto));
		}
		return entities;
	}
	
	public ReviewDTO mapEntityToDto(ReviewEntity entity){
		if(entity == null){
			return null;
		}
		
		ReviewDTO dto = new ReviewDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setRating(mapTypeEntityToDto(entity.getRating()));
		dto.setDate(entity.getDate());
		dto.setText(entity.getText());
	
		
		return dto;
	}
	
	public ReviewEntity mapDtoToEntity(ReviewDTO dto){
		if(dto == null){
			return null;
		}
		
		ReviewEntity entity = new ReviewEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setRating(mapTypeDtoToEntity(dto.getRating()));
		entity.setDate(dto.getDate());
		entity.setText(dto.getText());
		
		return entity;
	}
	
	public RatingTypeDTO mapTypeEntityToDto(RatingTypeEntity entity){
		if(entity == null){
			return null;
		}
		
		RatingTypeDTO dto = REVIEW_TYPE_MAPPER.get(entity);
		
		if(dto == null){
			throw new IllegalArgumentException("Unknown Review type [" + entity.name() + "]");
		}
		
		return dto;
	}
	
	public RatingTypeEntity mapTypeDtoToEntity(RatingTypeDTO dto){
		if(dto == null){
			return null;
		}
		
		RatingTypeEntity entity = REVIEW_TYPE_MAPPER.inverse().get(dto);
		
		if(entity == null){
			throw new IllegalArgumentException("Unknown Review type [" + dto.name() + "]");
		}
		
		return entity;
	}
}
