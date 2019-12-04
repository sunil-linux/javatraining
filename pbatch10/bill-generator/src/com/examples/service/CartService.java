package com.examples.service;

import java.util.List;
import java.util.Map;

import com.examples.model.CartProduct;
import com.examples.model.ProdCategory;

public interface CartService {
	void addProduct(ProdCategory category, CartProduct prod);

	void deleteProduct(int prodId);

	List<CartProduct> getProductsByCategory(ProdCategory prodCategory);

	Map<ProdCategory, List<CartProduct>> getCart();
}
