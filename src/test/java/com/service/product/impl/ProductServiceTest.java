package com.service.product.impl;

import static org.junit.Assert.*;

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
import com.model.amanity.AmanityMapper;
import com.model.image.ImageMapper;
import com.model.product.ProductDTO;
import com.model.product.ProductEntity;
import com.model.product.ProductFactory;
import com.model.product.ProductMapper;
import com.model.productdetail.ProductDetailMapper;
import com.model.review.ReviewMapper;

public class ProductServiceTest {

	@Mock
	private ProductDAO productDao;

	@InjectMocks
	private ProductDetailMapper productDetailMapper;
	
	@InjectMocks
	private AmanityMapper amanityMapper;
	
	@InjectMocks
	private ReviewMapper reviewMapper;
	
	@InjectMocks
	private ImageMapper imageMapper;
	
	@InjectMocks
	private ProductMapper productMapper;

	@InjectMocks
	private ProductServiceImpl cut;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(productDetailMapper, "amanityMapper", new AmanityMapper());
		ReflectionTestUtils.setField(productDetailMapper, "reviewMapper", new ReviewMapper());
		ReflectionTestUtils.setField(productDetailMapper, "imageMapper", new ImageMapper());
		ReflectionTestUtils.setField(productMapper, "productDetailMapper", productDetailMapper);
		ReflectionTestUtils.setField(cut, "productMapper", productMapper);
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
	
	@Test
	public void testGetProductByName() {
		String name = "test";
		
		List<ProductEntity> expected = ProductFactory.generateRandomProductEntities(RandomUtils.nextInt(0, 100), name);

		Mockito.when(productDao.findAllByName(name)).thenReturn(expected);

		List<ProductDTO> actual = cut.getProductsByName(name);

		assertEquals(expected.size(), actual.size());
		
		for (ProductDTO dto : actual) {
			assertTrue(dto.getName().contains(name));
		}
	}
	
//	@Test
//	public void testGetAllProductNames() {
//		
//		List<String> expected = ProductFactory.generateRandomProductEntitiesSorted(RandomUtils.nextInt(0, 100));
//
//		Mockito.when(productDao.getAllProductNames()).thenReturn(expected);
//
//		List<String> actual = cut.getAllProductNames();
//
//		assertEquals(expected.size(), actual.size());
//		
//		for (String dto : actual) {
//			assertTrue(dto.getName().contains());
//		}
//	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpdateProduct_Null() {
		cut.updateProduct(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteProduct_Null() {
		cut.deleteProduct(null);
	}

}
