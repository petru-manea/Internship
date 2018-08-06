package dao.product.impl;

import java.util.List;

import config.GenericDAOImpl;
import dao.product.ProductDAO;
import model.product.ProductEntity;

public class ProductDAOImpl extends GenericDAOImpl<ProductEntity, Integer> implements ProductDAO {

	public ProductDAOImpl(Class<ProductEntity> persistentClass) {
		super(ProductEntity.class);
	}

	@Override
	public void save(ProductEntity entity) {
		super.save(entity);
		flush();
	}

	@Override
	public ProductEntity update(ProductEntity entity) {
		ProductEntity updatedEntity = super.update(entity);
		flush();
		return updatedEntity;
	}

	@Override
	public void delete(ProductEntity entity) {
		super.delete(entity);
		flush();
	}

	@Override
	public ProductEntity findById(Integer id) {
		ProductEntity entity = super.findById(id);
		return entity;
	}

	@Override
	public List<ProductEntity> findAll() {
		return super.findAll();
	}

	@Override
	public void flush() {
		super.flush();
	}

}
