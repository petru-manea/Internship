package com.dao.product;

import java.util.List;

import com.config.GenericDAO;
import com.model.product.ProductEntity;

public interface ProductDAO extends GenericDAO<ProductEntity, Integer> {

	/**
	 * Retrieves all products that contain a certain name for database
	 * @param name
	 * @return
	 */
	List<ProductEntity> findAllByName(String name);

	/**
	 *  Retrieves all name for database
	 * @return
	 */
	List<String> getAllProductNames();
	
}
