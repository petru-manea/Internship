package service.product;

import model.product.ProductDTO;

public interface ProductService {

	/**
	 * 
	 * @param product
	 */
	void addProduct(ProductDTO product);

	/**
	 * 
	 * @param id
	 * @return
	 */
	ProductDTO getProductById(Integer id);

	ProductDTO getProductById(String id);

	void updateProduct(ProductDTO product);
	/**
	 * 
	 * @param update product
	 */

	void deleteProduct(ProductDTO product);
	/**
	 *
	 * @param delete product
	 */

}
