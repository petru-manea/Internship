package com.model.review;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import com.model.product.ProductDTO;
import com.model.product.ProductEntity;
import com.model.product.ProductFactory;
import com.model.product.ProductTypeDTO;
import com.model.product.ProductTypeEntity;

public class ReviewMapperTest {

	private ReviewMapper cut = new ReviewMapper();

	@Test
	public void testMapEntityToDto_NotNull() {
		ReviewEntity expected = ReviewFactory.generateRandomReviewEntity();

		ReviewDTO result = cut.mapEntityToDto(expected);

		ReviewEntity actual = cut.mapDtoToEntity(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getRating(), actual.getRating());
		assertEquals(expected.getDate(), actual.getDate());
		assertEquals(expected.getText(), actual.getText());

	}
	
	@Test
	public void testMapEntityToDto_Null() {
		assertNull(cut.mapEntityToDto(null));
	}

	@Test
	public void testMapDtoToEntity_NotNull() {

	  	ReviewDTO expected = ReviewFactory.generateRandomReviewDTO();

		ReviewEntity result = cut.mapDtoToEntity(expected);

		ReviewDTO actual = cut.mapEntityToDto(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getRating(), actual.getRating());
		assertEquals(expected.getDate(), actual.getDate());
		assertEquals(expected.getText(), actual.getText());
	}

	@Test
	public void testMapDtoToEntity_Null() {
		assertNull(cut.mapDtoToEntity(null));
	}
	
	@Test
	public void testMapTypeEntityToDto_NotNull() {
		ReviewTypeEntity expected = ReviewFactory.generateRandomReviewTypeEntity();

		ReviewTypeDTO result = cut.mapTypeEntityToDto(expected);

		ReviewTypeEntity actual = cut.mapTypeDtoToEntity(result);

		assertEquals(expected.name(), actual.name());
	}

	@Test
	public void testMapTypeEntityToDto_Null() {
		assertNull(cut.mapTypeEntityToDto(null));
	}
	
	@Test
	public void testMapTypeDtoToEntity_NotNull() {

		ReviewTypeDTO expected = ReviewFactory.generateRandomReviewTypeDTO();

		ReviewTypeEntity result = cut.mapTypeDtoToEntity(expected);

		ReviewTypeDTO actual = cut.mapTypeEntityToDto(result);

		assertEquals(expected.name(), actual.name());
	}

	@Test
	public void testMapTypeDtoToEntity_Null() {
		assertNull(cut.mapTypeDtoToEntity(null));
	}
	
	@Test
	public void testMapEntitiesToDto_NotNull(){
		List<ReviewEntity> expected = ReviewFactory.generateRandomReviewEntities(RandomUtils.nextInt(0, 100));
		
		List<ReviewDTO> result = cut.mapEntitiesToDto(expected);
		
		List<ReviewEntity> actual = cut.mapDtosToEntity(result);
	
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ReviewEntity entity : expected){
			for(ReviewEntity otherEntity : actual){
				if(entity.getId().equals(otherEntity.getId())){
					found++;
				}
			}
		}
		
		assertEquals(expected.size(), found);
	}
	
	@Test
	public void testMapEntitesToDto_Null() {
		assertNull(cut.mapEntitiesToDto(null));
	}
	
	@Test
	public void testMapDtosToEntity_NotNull(){
		List<ReviewDTO> expected = ReviewFactory.generateRandomReviewDtos(RandomUtils.nextInt(0, 100));
		
		List<ReviewEntity> result = cut.mapDtosToEntity(expected);
		
		List<ReviewDTO> actual = cut.mapEntitiesToDto(result);
		
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ReviewDTO dto : expected){
			for(ReviewDTO otherDto : actual){
				if(dto.getId().equals(otherDto.getId())){
					found++;
				}
			}
		}
		assertEquals(expected.size(), found);
	}
	
	@Test
	public void testMapDtosToEntity_Null() {
		assertNull(cut.mapDtosToEntity(null));
	}
}
