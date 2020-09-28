package com.spring.product.dao;

import java.util.List;

import com.spring.product.model.Product;

public interface ProductDao 
{
	public Product saveProduct(Product product);

	public List<Product> getProducts();

	public Product getProduct(Integer id);

	public void deleteProduct(Product product);

}
