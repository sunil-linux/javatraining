package com.examples.service;

import java.util.List;
import java.util.Map;

import com.examples.model.CartProduct;
import com.examples.model.ProdCategory;

public class BillGeneratorService {

	private CartService shoppingCartService;
	private TaxCalculatorService taxCalculatorService;

	public BillGeneratorService(CartService shoppingCartService, TaxCalculatorService taxCalculatorService) {
		super();
		this.shoppingCartService = shoppingCartService;
		this.taxCalculatorService = taxCalculatorService;
	}

	public void generateBill() {

		Map<ProdCategory, List<CartProduct>> cart = shoppingCartService.getCart();

		double totalBill = 0;

		System.out.println("Name\tPrice\tQty\tPrice\tTaxPrice");
		System.out.println("------------------------------------------------------------");
		for (ProdCategory category : cart.keySet()) {
			List<CartProduct> products = cart.get(category);
			for (CartProduct product : products) {
				double totalPriceOfProduct = taxCalculatorService.getFinalPriceFor(category, product.getPrice(),
						product.getQty());

				System.out.println(product.getProdName() + "\t" + product.getPrice() + "\t" + product.getQty() + "\t"+(product.getPrice()*product.getQty())+"\t"+
						+ totalPriceOfProduct);
				totalBill += totalPriceOfProduct;
			}
		}

		System.out.println("------------------------------------------------------------");

		System.out.println("Total Amount:" + totalBill);
	}

}
