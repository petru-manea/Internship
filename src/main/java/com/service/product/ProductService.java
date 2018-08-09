package com.service.product;


import java.util.List;

import com.model.product.ProductDTO;


public interface ProductService  {
	 

	/**
	 * Saves the product to database
	 * 
	 * @param product
	 */
	void addProduct(ProductDTO product);

	/**
	 * Retrieves the product from database based on id
	 * 
	 * @param id
	 * @return
	 */
	ProductDTO getProductById(String id);

	/**
	 * Updates the product with new values
	 * 
	 * @param product
	 */
	void updateProduct(ProductDTO product);

	/**
	 * Removes the product from database
	 * 
	 * @param product
	 */
	void deleteProduct(ProductDTO product);

	/**
	 * Retrieves the list of products in the database 
	 * 
	 * @return
	 */
	List<ProductDTO> getProducts();

}
