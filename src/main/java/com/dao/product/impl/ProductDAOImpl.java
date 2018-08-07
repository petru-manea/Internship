package com.dao.product.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.config.GenericDAOImpl;
import com.dao.product.ProductDAO;
import com.model.product.ProductEntity;

@Component
public class ProductDAOImpl extends GenericDAOImpl<ProductEntity, Integer> implements ProductDAO {

	public ProductDAOImpl() {
		super(ProductEntity.class);
	}

	@Override
	@Transactional
	public void save(ProductEntity entity) {
		super.save(entity);
		flush();
	}

	@Override
	@Transactional
	public ProductEntity update(ProductEntity entity) {
		ProductEntity updatedEntity = super.update(entity);
		flush();
		return updatedEntity;
	}

	@Override
	@Transactional
	public void delete(ProductEntity entity) {
		super.delete(entity);
		flush();
	}

	@Override
	@Transactional
	public ProductEntity findById(Integer id) {
		ProductEntity entity = super.findById(id);
		return entity;
	}

	@Override
	@Transactional
	public List<ProductEntity> findAll() {
		return super.findAll();
	}

	@Override
	@Transactional
	public void flush() {
		super.flush();
	}

}
