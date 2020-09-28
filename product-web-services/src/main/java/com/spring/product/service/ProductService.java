package com.spring.product.service;

import java.util.List;

import com.spring.product.model.Product;

public interface ProductService 
{
	public Product saveProduct(Product product);

	public List<Product> getProducts();

	public Product getProduct(Integer id);

	public Product deleteProduct(Integer id);
}
