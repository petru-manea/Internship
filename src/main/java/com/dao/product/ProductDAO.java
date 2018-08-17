package com.dao.product;

import java.util.List;

import com.config.GenericDAO;
import com.model.product.ProductEntity;

public interface ProductDAO extends GenericDAO<ProductEntity, Integer> {

	/**
	 * Retrieves all products that contain a certain name in the database
	 * @param name
	 * @return
	 */
	List<ProductEntity> findAllByName(String name);

	/**
	 *  Retrieves all name in the database
	 * @return
	 */
	List<String> getAllProductNames();
	
	/**
	 * Retrieves  all products in the database 
	 * @return
	 */
	List<ProductEntity> sortedByName();
	
}
