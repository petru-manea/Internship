package com.model.product;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

@Component
public class ProductMapper {
	
	private static final BiMap<ProductTypeEntity, ProductTypeDTO> PRODUCT_TYPE_MAPPER = new ImmutableBiMap.Builder<ProductTypeEntity, ProductTypeDTO>()
			.put(ProductTypeEntity.HOUSE, ProductTypeDTO.HOUSE)
			.put(ProductTypeEntity.VILLA, ProductTypeDTO.VILLA)
			.put(ProductTypeEntity.APARTAMENT, ProductTypeDTO.APARTMENT)
			.put(ProductTypeEntity.HOTEL, ProductTypeDTO.HOTEL)
			.build();

	public ProductDTO mapEntityToDto(ProductEntity entity){
		if(entity == null){
			return null;
		}
		
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setType(mapTypeEntityToDto(entity.getType()));
		dto.setArea(entity.getArea());
		dto.setLocation(entity.getLocation());
		dto.setImage(entity.getImage());
		
		return dto;
	}
	
	public ProductEntity mapDtoToEntity(ProductDTO dto){
		if(dto == null){
			return null;
		}
		
		ProductEntity entity = new ProductEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setType(mapTypeDtoToEntity(dto.getType()));
		entity.setArea(dto.getArea());
		entity.setLocation(dto.getLocation());
		entity.setImage(dto.getImage());
		
		return entity;
	}
	
	public ProductTypeDTO mapTypeEntityToDto(ProductTypeEntity entity){
		if(entity == null){
			return null;
		}
		
		ProductTypeDTO dto = PRODUCT_TYPE_MAPPER.get(entity);
		
		if(dto == null){
			throw new IllegalArgumentException("Unknown product type [" + entity.name() + "]");
		}
		
		return dto;
	}
	
	public ProductTypeEntity mapTypeDtoToEntity(ProductTypeDTO dto){
		if(dto == null){
			return null;
		}
		
		ProductTypeEntity entity = PRODUCT_TYPE_MAPPER.inverse().get(dto);
		
		if(entity == null){
			throw new IllegalArgumentException("Unknown product type [" + dto.name() + "]");
		}
		
		return entity;
	}

	public List<ProductDTO> mapEntitiesToDto(List<ProductEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}
}
