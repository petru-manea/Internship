package com.model.productdetail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.model.amanity.AmanityMapper;
import com.model.image.ImageMapper;
import com.model.review.ReviewMapper;

@Component
public class ProductDetailMapper {

	@Autowired
	private AmanityMapper amanityMapper;

	@Autowired
	private ReviewMapper reviewMapper;

	@Autowired
	private ImageMapper imageMapper;

	public List<ProductDetailDTO> mapEntitiesToDto(List<ProductDetailEntity> entities) {
		if (entities == null) {
			return null;
		}

		List<ProductDetailDTO> dtos = new ArrayList<>();
		for (ProductDetailEntity entity : entities) {
			dtos.add(mapEntityToDto(entity));
		}
		return dtos;
	}

	public List<ProductDetailEntity> mapDtosToEntity(List<ProductDetailDTO> dtos) {
		if (dtos == null) {
			return null;
		}
		List<ProductDetailEntity> entities = new ArrayList<>();

		for (ProductDetailDTO dto : dtos) {
			entities.add(mapDtoToEntity(dto));
		}
		return entities;
	}

	public ProductDetailDTO mapEntityToDto(ProductDetailEntity entity) {
		if (entity == null) {
			return null;
		}

		ProductDetailDTO dto = new ProductDetailDTO();
		dto.setId(entity.getId());
		dto.setAddress(entity.getAddress());
		dto.setRating(entity.getRating());
		dto.setSleeps(entity.getSleeps());
		dto.setBedrooms(entity.getBedrooms());
		dto.setBathrooms(entity.getBathrooms());
		dto.setDescription(entity.getDescription());
		if (entity.getAmanities() != null) {
			dto.setAmanities(amanityMapper.mapEntitiesToDto(Lists.newArrayList(entity.getAmanities())));
		}
		if (entity.getReviews() != null) {
			dto.setReviews(reviewMapper.mapEntitiesToDto(Lists.newArrayList(entity.getReviews())));
		}
		if (entity.getImages() != null) {
			dto.setImages(imageMapper.mapEntitiesToDto(Lists.newArrayList(entity.getImages())));
		}
		return dto;
	}

	public ProductDetailEntity mapDtoToEntity(ProductDetailDTO dto) {
		if (dto == null) {
			return null;
		}

		ProductDetailEntity entity = new ProductDetailEntity();
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		entity.setRating(dto.getRating());
		entity.setSleeps(dto.getSleeps());
		entity.setBedrooms(dto.getBedrooms());
		entity.setBathrooms(dto.getBathrooms());
		entity.setDescription(dto.getDescription());
		if (dto.getAmanities() != null) {
			entity.setAmanities(amanityMapper.mapDtosToEntity(Lists.newArrayList(dto.getAmanities())));
		}
		if (dto.getReviews() != null) {
			entity.setReviews(reviewMapper.mapDtosToEntity(Lists.newArrayList(dto.getReviews())));
		}
		if (dto.getImages() != null) {
			entity.setImages(imageMapper.mapDtosToEntity(Lists.newArrayList(dto.getImages())));
		}

		return entity;
	}

}
