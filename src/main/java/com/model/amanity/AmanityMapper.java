package com.model.amanity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

@Component
public class AmanityMapper {
	private static final BiMap<AmanityTypeEntity, AmanityTypeDTO> AMANITY_TYPE_MAPPER = new ImmutableBiMap.Builder<AmanityTypeEntity, AmanityTypeDTO>()
			.put(AmanityTypeEntity.COFFEE_MAKER, AmanityTypeDTO.COFFEE_MAKER)
			.put(AmanityTypeEntity.	COOKING_UTENSILS, AmanityTypeDTO.COOKING_UTENSILS)
			.put(AmanityTypeEntity.ICE_MAKER, AmanityTypeDTO.ICE_MAKER)
			.put(AmanityTypeEntity.MICROWAVE, AmanityTypeDTO.MICROWAVE)
			.put(AmanityTypeEntity.STOVE, AmanityTypeDTO.STOVE)
			.put(AmanityTypeEntity.PLAYGROUND, AmanityTypeDTO.PLAYGROUND)
			.build();

	public List<AmanityDTO> mapEntitiesToDto(List<AmanityEntity> entities){
		if(entities == null){
			return null;
		}
		
		List<AmanityDTO> dtos = new ArrayList<>();
		for(AmanityEntity entity : entities){
			dtos.add(mapEntityToDto(entity));
		}
		return dtos;
	}
	
	public List<AmanityEntity> mapDtosToEntity(List<AmanityDTO> dtos){
		if(dtos == null){
			return null;
		}
		List<AmanityEntity> entities = new ArrayList<>();
		
		for(AmanityDTO dto : dtos){
			entities.add(mapDtoToEntity(dto));
		}
		return entities;
	}
	
	public AmanityDTO mapEntityToDto(AmanityEntity entity){
		if(entity == null){
			return null;
		}
		
		AmanityDTO dto = new AmanityDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());

		return dto;
	}
	
	public AmanityEntity mapDtoToEntity(AmanityDTO dto){
		if(dto == null){
			return null;
		}
		
		AmanityEntity entity = new AmanityEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		
		return entity;
	}
	
	public AmanityTypeDTO mapTypeEntityToDto(AmanityTypeEntity entity){
		if(entity == null){
			return null;
		}
		
		AmanityTypeDTO dto = AMANITY_TYPE_MAPPER.get(entity);
		
		if(dto == null){
			throw new IllegalArgumentException("Unknown Review type [" + entity.name() + "]");
		}
		
		return dto;
	}
	
	public AmanityTypeEntity mapTypeDtoToEntity(AmanityTypeDTO dto){
		if(dto == null){
			return null;
		}
		
		AmanityTypeEntity entity = AMANITY_TYPE_MAPPER.inverse().get(dto);
		
		if(entity == null){
			throw new IllegalArgumentException("Unknown Review type [" + dto.name() + "]");
		}
		
		return entity;
	}
}
