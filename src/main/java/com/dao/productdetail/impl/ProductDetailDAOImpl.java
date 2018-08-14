package com.dao.productdetail.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.config.GenericDAOImpl;
import com.dao.productdetail.ProductDetailDAO;
import com.model.productdetail.ProductDetailEntity;

@Component
public class ProductDetailDAOImpl extends GenericDAOImpl<ProductDetailEntity, Integer> implements ProductDetailDAO {
	
	public ProductDetailDAOImpl() {
		super(ProductDetailEntity.class);
	}

	@Override
	@Transactional
	public void save(ProductDetailEntity entity) {
		super.save(entity);
		flush();
	}

	@Override
	@Transactional
	public ProductDetailEntity update(ProductDetailEntity entity) {
		ProductDetailEntity updatedEntity = super.update(entity);
		flush();
		return updatedEntity;
	}

	@Override
	@Transactional
	public void delete(ProductDetailEntity entity) {
		super.delete(entity);
		flush();
	}

	@Override
	@Transactional
	public ProductDetailEntity findById(Integer id) {
		ProductDetailEntity entity = super.findById(id);
		return entity;
	}

	@Override
	@Transactional
	public List<ProductDetailEntity> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional
	public void flush() {
		super.flush();
	}
}
