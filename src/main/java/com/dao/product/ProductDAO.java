package com.dao.product;

import java.util.List;

import com.config.GenericDAO;
import com.model.product.ProductEntity;

public interface ProductDAO extends GenericDAO<ProductEntity, Integer> {

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<ProductEntity> findAllByName(String name);
	
}
