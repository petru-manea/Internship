package com.model.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.model.productdetail.ProductDetailMapper;

@Component
public class ProductMapper {

	@Autowired
	private ProductDetailMapper productDetailMapper;

	private static final BiMap<ProductTypeEntity, ProductTypeDTO> PRODUCT_TYPE_MAPPER = new ImmutableBiMap.Builder<ProductTypeEntity, ProductTypeDTO>()
			.put(ProductTypeEntity.HOUSE, ProductTypeDTO.HOUSE).put(ProductTypeEntity.VILLA, ProductTypeDTO.VILLA)
			.put(ProductTypeEntity.APARTAMENT, ProductTypeDTO.APARTMENT)
			.put(ProductTypeEntity.HOTEL, ProductTypeDTO.HOTEL).build();

	public List<ProductDTO> mapEntitiesToDto(List<ProductEntity> entities) {
		if (entities == null) {
			return null;
		}

		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity entity : entities) {
			dtos.add(mapEntityToDto(entity));
		}
		return dtos;
	}

	public List<ProductEntity> mapDtosToEntity(List<ProductDTO> dtos) {
		if (dtos == null) {
			return null;
		}
		List<ProductEntity> entities = new ArrayList<>();

		for (ProductDTO dto : dtos) {
			entities.add(mapDtoToEntity(dto));
		}
		return entities;
	}

	public ProductDTO mapEntityToDto(ProductEntity entity) {
		if (entity == null) {
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
		if (entity.getProductDetail() != null) {
			dto.setProductDetail(productDetailMapper.mapEntityToDto(entity.getProductDetail()));
		}

		return dto;

	}

	public ProductEntity mapDtoToEntity(ProductDTO dto) {
		if (dto == null) {
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
		if (dto.getProductDetail() != null) {
			entity.setProductDetail(productDetailMapper.mapDtoToEntity(dto.getProductDetail()));
		}

		return entity;
	}

	public ProductTypeDTO mapTypeEntityToDto(ProductTypeEntity entity) {
		if (entity == null) {
			return null;
		}

		ProductTypeDTO dto = PRODUCT_TYPE_MAPPER.get(entity);

		if (dto == null) {
			throw new IllegalArgumentException("Unknown product type [" + entity.name() + "]");
		}

		return dto;
	}

	public ProductTypeEntity mapTypeDtoToEntity(ProductTypeDTO dto) {
		if (dto == null) {
			return null;
		}

		ProductTypeEntity entity = PRODUCT_TYPE_MAPPER.inverse().get(dto);

		if (entity == null) {
			throw new IllegalArgumentException("Unknown product type [" + dto.name() + "]");
		}

		return entity;
	}
}
