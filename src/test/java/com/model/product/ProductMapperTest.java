package com.model.product;

import static org.junit.Assert.*;

import org.junit.Test;
import com.model.product.ProductFactory;

public class ProductMapperTest {

	private ProductMapper cut = new ProductMapper();

	@Test
	public void testMapEntityToDto() {
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
	public void testMapDtoToEntity() {
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
	public void testMapTypeEntityToDto() {
		ProductTypeEntity expected = ProductFactory.generateRandomProductTypeEntity();

		ProductTypeDTO result = cut.mapTypeEntityToDto(expected);

		ProductTypeEntity actual = cut.mapTypeDtoToEntity(result);

		assertEquals(expected.name(), actual.name());
	}

	@Test
	public void testMapTypeDtoToEntity() {

		ProductTypeDTO expected = ProductFactory.generateRandomProductTypeDTO();

		ProductTypeEntity result = cut.mapTypeDtoToEntity(expected);

		ProductTypeDTO actual = cut.mapTypeEntityToDto(result);

		assertEquals(expected.name(), actual.name());
	}

}
