package com.service.product.impl;

import java.util.Collections;
import java.util.List;

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
		if (product != null) {
			productDao.save(productMapper.mapDtoToEntity(product));
		} else {
			throw new IllegalArgumentException("Product is null!");
		}
	}

	@Override
	public void updateProduct(ProductDTO product) {
		if (product != null) {
			productDao.update(productMapper.mapDtoToEntity(product));
		} else {
			throw new IllegalArgumentException("Product is null!");
		}
	}

	@Override
	public void deleteProduct(ProductDTO product) {
		if (product != null) {
			productDao.delete(productMapper.mapDtoToEntity(product));
		} else {
			throw new IllegalArgumentException("Product is null!");
		}
	}

	@Override
	public List<ProductDTO> getProducts() {
		List<ProductEntity> entities = productDao.findAll();
		return productMapper.mapEntitiesToDto(entities);
	}

	@Override
	public ProductDTO getProductById(String id) {
		ProductEntity entity = productDao.findById(new Integer(id));
		return productMapper.mapEntityToDto(entity);
	}

	@Override
	public List<ProductDTO> getProductsByName(String name) {
		List<ProductEntity> entities = productDao.findAllByName(name);
		return productMapper.mapEntitiesToDto(entities);
	}

	@Override
	public List<String> getAllProductNames() {
		return productDao.getAllProductNames();
	}

	@Override
	public List<ProductDTO> sortedByName() {
		List<ProductEntity> entities = productDao.sortedByName();
		return productMapper.mapEntitiesToDto(entities);
	}

	@Override
	public List<ProductDTO> sortedByPrice() {
		List<ProductEntity> entities = productDao.findAll();
		List<ProductDTO> dtos = productMapper.mapEntitiesToDto(entities);
		Collections.sort(dtos, new ProductPriceComparator());
		return dtos;
	}

}
