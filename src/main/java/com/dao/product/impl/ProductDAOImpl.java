package com.dao.product.impl;

import java.util.List;

import javax.persistence.TypedQuery;

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

	@Override
	@Transactional
	public List<ProductEntity> findAllByName(String name) {
		TypedQuery<ProductEntity> query =
				getEntityManager().createNamedQuery(ProductEntity.FIND_BY_NAME, ProductEntity.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<String> getAllProductNames() {
		TypedQuery<String> query =
				getEntityManager().createNamedQuery(ProductEntity.GET_ALL_PRODUCT_NAMES, String.class);
		return query.getResultList();
	}

	@Override
	public List<ProductEntity> sortedByName() {
		TypedQuery<ProductEntity> query =
				getEntityManager().createNamedQuery(ProductEntity.SORTED_ALL_PRODUCTS_BY_NAMES, ProductEntity.class);
		return query.getResultList();
	}

}
