package com.service.product.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.dao.product.ProductDAO;
import com.model.product.ProductDTO;
import com.model.product.ProductEntity;
import com.model.product.ProductFactory;
import com.model.product.ProductMapper;

public class ProductServiceTest {

	@Mock
	private ProductDAO productDao;

	@InjectMocks
	private ProductMapper productMapper;

	@InjectMocks
	private ProductServiceImpl cut;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(cut, "productMapper", new ProductMapper());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddProduct_Null() {
		cut.addProduct(null);
	}

	@Test
	public void testGetProductById() {
		String id = "2";

		ProductEntity expected = ProductFactory.generateRandomProductEntity(new Integer(id));

		Mockito.when(productDao.findById(Mockito.anyInt())).thenReturn(expected);

		ProductDTO actual = cut.getProductById(id);

		assertEquals(expected.getId(), actual.getId());
	}

	@Test
	public void testGetProducts() {

		List<ProductEntity> expected = ProductFactory.generateRandomProductEntities(RandomUtils.nextInt(0, 100));

		Mockito.when(productDao.findAll()).thenReturn(expected);

		List<ProductDTO> actual = cut.getProducts();

		assertEquals(expected.size(), actual.size());

		int found = 0;
		for (ProductEntity entity : expected) {
			for (ProductDTO dto : actual) {
				if (entity.getId().equals(dto.getId())) {
					found++;
				}
			}
		}
		assertEquals(expected.size(), found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpdateProduct_Null() {
		cut.updateProduct(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteProduct_Null() {
		cut.deleteProduct(null);
	}

}