package com.model.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class ProductMapperTest {

	private ProductMapper cut = new ProductMapper();

	@Test
	public void testMapEntityToDto_NotNull() {
		ProductEntity expected = ProductFactory.generateRandomProductEntity();

		ProductDTO result = cut.mapEntityToDto(expected);

		ProductEntity actual = cut.mapDtoToEntity(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getPrice(), actual.getPrice());
		assertEquals(expected.getType(), actual.getType());
		assertEquals(expected.getArea(), actual.getArea());
		assertEquals(expected.getLocation(), actual.getLocation());
		assertEquals(expected.getImage(), actual.getImage());
	}
	
	@Test
	public void testMapEntityToDto_Null() {
		assertNull(cut.mapEntityToDto(null));
	}

	@Test
	public void testMapDtoToEntity_NotNull() {
		ProductDTO expected = ProductFactory.generateRandomProductDTO();

		ProductEntity result = cut.mapDtoToEntity(expected);

		ProductDTO actual = cut.mapEntityToDto(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getPrice(), actual.getPrice());
		assertEquals(expected.getType(), actual.getType());
		assertEquals(expected.getArea(), actual.getArea());
		assertEquals(expected.getLocation(), actual.getLocation());
		assertEquals(expected.getImage(), actual.getImage());
	}

	@Test
	public void testMapDtoToEntity_Null() {
		assertNull(cut.mapDtoToEntity(null));
	}
	
	@Test
	public void testMapTypeEntityToDto_NotNull() {
		ProductTypeEntity expected = ProductFactory.generateRandomProductTypeEntity();

		ProductTypeDTO result = cut.mapTypeEntityToDto(expected);

		ProductTypeEntity actual = cut.mapTypeDtoToEntity(result);

		assertEquals(expected.name(), actual.name());
	}

	@Test
	public void testMapTypeEntityToDto_Null() {
		assertNull(cut.mapTypeEntityToDto(null));
	}
	
	@Test
	public void testMapTypeDtoToEntity_NotNull() {

		ProductTypeDTO expected = ProductFactory.generateRandomProductTypeDTO();

		ProductTypeEntity result = cut.mapTypeDtoToEntity(expected);

		ProductTypeDTO actual = cut.mapTypeEntityToDto(result);

		assertEquals(expected.name(), actual.name());
	}

	@Test
	public void testMapTypeDtoToEntity_Null() {
		assertNull(cut.mapTypeDtoToEntity(null));
	}
	
	@Test
	public void testMapEntitiesToDto_NotNull(){
		List<ProductEntity> expected = ProductFactory.generateRandomProductEntities(RandomUtils.nextInt(0, 100));
		
		List<ProductDTO> result = cut.mapEntitiesToDto(expected);
		
		List<ProductEntity> actual = cut.mapDtosToEntity(result);
	
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ProductEntity entity : expected){
			for(ProductEntity otherEntity : actual){
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
		List<ProductDTO> expected = ProductFactory.generateRandomProductDtos(RandomUtils.nextInt(0, 100));
		
		List<ProductEntity> result = cut.mapDtosToEntity(expected);
		
		List<ProductDTO> actual = cut.mapEntitiesToDto(result);
		
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ProductDTO dto : expected){
			for(ProductDTO otherDto : actual){
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
