package com.model.ProductDetail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.model.amanity.AmanityMapper;
import com.model.image.ImageMapper;
import com.model.productdetail.ProductDetailDTO;
import com.model.productdetail.ProductDetailEntity;
import com.model.productdetail.ProductDetailMapper;
import com.model.review.ReviewMapper;

public class ProductDetailsMapperTest {

	@InjectMocks
	private AmanityMapper amanityMapper;
	
	@InjectMocks
	private ReviewMapper reviewMapper;
	
	@InjectMocks
	private ImageMapper imageMapper;
	
	private ProductDetailMapper cut = new ProductDetailMapper();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(cut, "amanityMapper", new AmanityMapper());
		ReflectionTestUtils.setField(cut, "reviewMapper", new ReviewMapper());
		ReflectionTestUtils.setField(cut, "imageMapper", new ImageMapper());
	}
	
	@Test
	public void testMapEntityToDto_NotNull() {
		ProductDetailEntity expected = ProductDetailFactory.generateRandomProductDetailEntity();

		ProductDetailDTO result = cut.mapEntityToDto(expected);

		ProductDetailEntity actual = cut.mapDtoToEntity(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getAddress(), actual.getAddress());
		assertEquals(expected.getRating(), actual.getRating());
		assertEquals(expected.getSleeps(), actual.getSleeps());
		assertEquals(expected.getBedrooms(), actual.getBedrooms());
		assertEquals(expected.getBathrooms(), actual.getBathrooms());
		assertEquals(expected.getDescription(), actual.getDescription());
	}
	
	@Test
	public void testMapEntityToDto_Null() {
		assertNull(cut.mapEntityToDto(null));
	}

	@Test
	public void testMapDtoToEntity_NotNull() {
		ProductDetailDTO expected = ProductDetailFactory.generateRandomProductDetailDTO();

		ProductDetailEntity result = cut.mapDtoToEntity(expected);

		ProductDetailDTO actual = cut.mapEntityToDto(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getAddress(), actual.getAddress());
		assertEquals(expected.getRating(), actual.getRating());
		assertEquals(expected.getSleeps(), actual.getSleeps());
		assertEquals(expected.getBedrooms(), actual.getBedrooms());
		assertEquals(expected.getBathrooms(), actual.getBathrooms());
		assertEquals(expected.getDescription(), actual.getDescription());
	}

	@Test
	public void testMapDtoToEntity_Null() {
		assertNull(cut.mapDtoToEntity(null));
	}
		
	@Test
	public void testMapEntitiesToDto_NotNull(){
		List<ProductDetailEntity> expected = ProductDetailFactory.generateRandomProductDetailEntities(RandomUtils.nextInt(0, 100));
		
		List<ProductDetailDTO> result = cut.mapEntitiesToDto(expected);
		
		List<ProductDetailEntity> actual = cut.mapDtosToEntity(result);
	
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ProductDetailEntity entity : expected){
			for(ProductDetailEntity otherEntity : actual){
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
		List<ProductDetailDTO> expected = ProductDetailFactory.generateRandomProductDetailDtos(RandomUtils.nextInt(0, 100));
		
		List<ProductDetailEntity> result = cut.mapDtosToEntity(expected);
		
		List<ProductDetailDTO> actual = cut.mapEntitiesToDto(result);
		
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ProductDetailDTO dto : expected){
			for(ProductDetailDTO otherDto : actual){
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
