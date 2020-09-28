package com.spring.product.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.spring.product.dao.ProductDao;
import com.spring.product.exception.ResourceNotFoundException;
import com.spring.product.model.Product;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private ProductDao productDao;

	@Override
	public Product saveProduct(Product product)
	{
		product.setAddedDate(LocalDateTime.now());
		product.setUpdatedDate(LocalDateTime.now());
		
		return productDao.saveProduct(product);
	}

	@Override
	public List<Product> getProducts()
	{
		return productDao.getProducts();
	}

	@Override
	public Product getProduct(Integer id)
	{
		return productDao.getProduct(id);
	}

	@Override
	public Product deleteProduct(Integer id)
	{
		Product product = productDao.getProduct(id);
		
		if(ObjectUtils.isEmpty(product))
			throw new ResourceNotFoundException("Product", "Id", id);
		
		productDao.deleteProduct(product);
		
		return product;
	}

}
