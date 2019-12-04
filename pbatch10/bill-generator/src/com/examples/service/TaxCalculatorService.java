package com.examples.service;

import java.util.HashMap;
import java.util.Map;

import com.examples.model.ProdCategory;

//Maintain category wise tax values & return final product price based on tax
public class TaxCalculatorService {

	private Map<ProdCategory, Double> categoryTaxMap = new HashMap<>();

	public TaxCalculatorService(Map<ProdCategory, Double> categoryTaxMap) {
		this.categoryTaxMap = categoryTaxMap;
	}

	public double getFinalPriceFor(ProdCategory prodCategory, double price, int qty) {
		// 1. Add price + actual tax for given category
		double tax = categoryTaxMap.get(prodCategory);
		double totalCost = price * qty;
		double totalTax = totalCost * tax;
		double totalAmount = totalCost + totalTax;
		return totalAmount;
	}
}
