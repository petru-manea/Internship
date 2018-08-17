package com.service.productdetail;

import java.util.List;

import com.model.productdetail.ProductDetailDTO;

public interface ProductDetailService {
	/**
	 * Retrieves the product from database based on id
	 * 
	 * @param id
	 * @return
	 */
	ProductDetailDTO getProductDetailById(String id);

	/**
	 * Removes the product from database
	 * 
	 * @param product
	 */
	void deleteProductDetail(ProductDetailDTO productdetail);

	/**
	 * Retrieves the list of products in the database
	 * 
	 * @return
	 */
	List<ProductDetailDTO> getProductsDetail();

	/**
	 * Saves the product to database
	 * 
	 * @param product
	 */
	void addProductDetail(ProductDetailDTO productdetail);

	/**
	 * Updates the product with new values
	 * 
	 * @param product
	 */
	void updateProductDetail(ProductDetailDTO productdetail);

}
