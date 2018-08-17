package com.service.productdetail;

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

import com.dao.productdetail.ProductDetailDAO;
import com.model.ProductDetail.ProductDetailFactory;
import com.model.amanity.AmanityMapper;
import com.model.image.ImageMapper;
import com.model.productdetail.ProductDetailDTO;
import com.model.productdetail.ProductDetailEntity;
import com.model.productdetail.ProductDetailMapper;
import com.model.review.ReviewMapper;
import com.service.productdetails.impl.ProductDetailServiceImpl;

public class ProductDetailServiceTest {

	@Mock
	private ProductDetailDAO productDetailDao;

	@InjectMocks
	private AmanityMapper amanityMapper;

	@InjectMocks
	private ReviewMapper reviewMapper;

	@InjectMocks
	private ImageMapper imageMapper;

	@InjectMocks
	private ProductDetailMapper productDetailMapper;

	@InjectMocks
	private ProductDetailServiceImpl cut;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(productDetailMapper, "amanityMapper", new AmanityMapper());
		ReflectionTestUtils.setField(productDetailMapper, "reviewMapper", new ReviewMapper());
		ReflectionTestUtils.setField(productDetailMapper, "imageMapper", new ImageMapper());
		ReflectionTestUtils.setField(cut, "productDetailMapper", productDetailMapper);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddProductDetail_Null() {
		cut.addProductDetail(null);
	}

	@Test
	public void testGetProductsDetail() {

		List<ProductDetailEntity> expected = ProductDetailFactory
				.generateRandomProductDetailEntities(RandomUtils.nextInt(0, 100));

		Mockito.when(productDetailDao.findAll()).thenReturn(expected);

		List<ProductDetailDTO> actual = cut.getProductsDetail();

		assertEquals(expected.size(), actual.size());

		int found = 0;
		for (ProductDetailEntity entity : expected) {
			for (ProductDetailDTO dto : actual) {
				if (entity.getId().equals(dto.getId())) {
					found++;
				}
			}
		}
		assertEquals(expected.size(), found);
	}

	@Test
	public void testGetProductDetailById() {
		String id = "2";

		ProductDetailEntity expected = ProductDetailFactory.generateRandomProductDetailEntity(new Integer(id));

		Mockito.when(productDetailDao.findById(Mockito.anyInt())).thenReturn(expected);

		ProductDetailDTO actual = cut.getProductDetailById(id);

		assertEquals(expected.getId(), actual.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpdateProductDetail_Null() {
		cut.updateProductDetail(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteProductDetail_Null() {
		cut.deleteProductDetail(null);
	}

}
