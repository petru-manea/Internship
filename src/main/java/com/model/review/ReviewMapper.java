package com.model.review;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

@Component
public class ReviewMapper {
	
	private static final BiMap<ReviewTypeEntity, ReviewTypeDTO> REVIEW_TYPE_MAPPER = new ImmutableBiMap.Builder<ReviewTypeEntity, ReviewTypeDTO>()
			.put(ReviewTypeEntity.ONE, ReviewTypeDTO.ONE)
			.put(ReviewTypeEntity.TWO, ReviewTypeDTO.TWO)
			.put(ReviewTypeEntity.THREE, ReviewTypeDTO.THREE)
			.put(ReviewTypeEntity.FOUR, ReviewTypeDTO.FOUR)
			.put(ReviewTypeEntity.FIVE, ReviewTypeDTO.FIVE)
			.put(ReviewTypeEntity.ZERO, ReviewTypeDTO.ZERO)
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
	
	public ReviewTypeDTO mapTypeEntityToDto(ReviewTypeEntity entity){
		if(entity == null){
			return null;
		}
		
		ReviewTypeDTO dto = REVIEW_TYPE_MAPPER.get(entity);
		
		if(dto == null){
			throw new IllegalArgumentException("Unknown Review type [" + entity.name() + "]");
		}
		
		return dto;
	}
	
	public ReviewTypeEntity mapTypeDtoToEntity(ReviewTypeDTO dto){
		if(dto == null){
			return null;
		}
		
		ReviewTypeEntity entity = REVIEW_TYPE_MAPPER.inverse().get(dto);
		
		if(entity == null){
			throw new IllegalArgumentException("Unknown Review type [" + dto.name() + "]");
		}
		
		return entity;
	}
}
