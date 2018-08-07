package com.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.product.ProductDAO;
import com.model.product.ProductDTO;
import com.model.product.ProductEntity;
import com.model.product.ProductMapper;
import com.service.product.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public void addProduct(ProductDTO product) {
		productDao.save(productMapper.mapDtoToEntity(product));
	}

	@Override
	public ProductDTO getProductById(String id) {
		ProductEntity entity = productDao.findById(new Integer(id));
		return productMapper.mapEntityToDto(entity);
	}

	@Override
	public void updateProduct(ProductDTO product) {
		productDao.update(productMapper.mapDtoToEntity(product));
	}

	@Override
	public void deleteProduct(ProductDTO product) {
		productDao.delete(productMapper.mapDtoToEntity(product));
	}

}
