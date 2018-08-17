package com.service.productdetails.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.productdetail.ProductDetailDAO;
import com.model.productdetail.ProductDetailDTO;
import com.model.productdetail.ProductDetailEntity;
import com.model.productdetail.ProductDetailMapper;
import com.service.productdetail.ProductDetailService;

@Component
public class ProductDetailServiceImpl implements ProductDetailService {

	@Autowired
	private ProductDetailDAO productDetailDao;

	@Autowired
	private ProductDetailMapper productDetailMapper;

	@Override
	public ProductDetailDTO getProductDetailById(String id) {
		ProductDetailEntity entity = productDetailDao.findById(new Integer(id));
		return productDetailMapper.mapEntityToDto(entity);
	}

	@Override
	public void deleteProductDetail(ProductDetailDTO productdetail) {
		if (productdetail != null) {
			productDetailDao.delete(productDetailMapper.mapDtoToEntity(productdetail));
		} else {
			throw new IllegalArgumentException("Product detail is null!");
		}
	}

	@Override
	public List<ProductDetailDTO> getProductsDetail() {
		List<ProductDetailEntity> entities = productDetailDao.findAll();
		return productDetailMapper.mapEntitiesToDto(entities);
	}

	@Override
	public void addProductDetail(ProductDetailDTO productdetail) {
		if (productdetail != null) {
			productDetailDao.save(productDetailMapper.mapDtoToEntity(productdetail));
		} else {
			throw new IllegalArgumentException("Product detail is null!");
		}
	}

	@Override
	public void updateProductDetail(ProductDetailDTO productdetail) {
		if (productdetail != null) {
			productDetailDao.update(productDetailMapper.mapDtoToEntity(productdetail));
		} else {
			throw new IllegalArgumentException("Product detail is null!");
		}
	}

}
