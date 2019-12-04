package com.examples;

import java.util.HashMap;
import java.util.Map;

import com.examples.model.CartProduct;
import com.examples.model.ProdCategory;
import com.examples.service.BillGeneratorService;
import com.examples.service.CartService;
import com.examples.service.ShoppingCartService;
import com.examples.service.TaxCalculatorService;

public class BillDeskApplication {

	public static void main(String[] args) {

		// 1.Assuming we already have inventory which has products stored into it. So
		// now are just adding direct prod to cart.

		CartService cartService = new ShoppingCartService();
		cartService.addProduct(ProdCategory.A, new CartProduct(1, "Sugar", 60, 2));
		cartService.addProduct(ProdCategory.A, new CartProduct(2, "Salt", 40, 4));
		cartService.addProduct(ProdCategory.B, new CartProduct(3, "Fan", 600, 1));
		cartService.addProduct(ProdCategory.B, new CartProduct(4, "Charger", 300, 2));
		cartService.addProduct(ProdCategory.C, new CartProduct(5, "Cap", 100, 5));
		cartService.addProduct(ProdCategory.C, new CartProduct(6, "Stick", 150, 3));

		// 2. Tax can vary based on category type of product. Customizable from outside
		// of bill generation part.
		Map<ProdCategory, Double> categoryTaxMap = new HashMap<>();
		categoryTaxMap.put(ProdCategory.A, 0.10);
		categoryTaxMap.put(ProdCategory.B, 0.20);
		categoryTaxMap.put(ProdCategory.C, 0.0);

		// 3. Calculate tax base on category of product
		TaxCalculatorService taxCalculatorService = new TaxCalculatorService(categoryTaxMap);

		// 4. Final calculation based on shopping cart item and by applying tax on each
		// item in cart.
		BillGeneratorService billGeneratorService = new BillGeneratorService(cartService, taxCalculatorService);
		billGeneratorService.generateBill();

	}
}
