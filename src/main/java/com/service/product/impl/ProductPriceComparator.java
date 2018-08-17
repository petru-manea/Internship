package com.service.product.impl;

import java.util.Comparator;

import com.model.product.ProductDTO;

public class ProductPriceComparator implements Comparator<ProductDTO> {

	@Override
	public int compare(ProductDTO product1, ProductDTO product2) {
		return product1.getPrice().compareTo(product2.getPrice());
	}

}
