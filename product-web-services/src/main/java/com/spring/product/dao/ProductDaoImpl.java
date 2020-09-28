package com.spring.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.product.exception.ResourceNotFoundException;
import com.spring.product.model.Product;
import com.spring.product.repository.ProductRepository;

@Service
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	private ProductRepository productRepository; 
	
	@Override
	public Product saveProduct(Product product)
	{
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProducts() 
	{
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProduct(Integer id) 
	{
		 Optional<Product> optProduct = productRepository.findById(id);
		 
		 if(!optProduct.isPresent())
			 throw new ResourceNotFoundException("Product", "Id", id);
		 
		return optProduct.get();
	}

	@Override
	public void deleteProduct(Product product)
	{
		productRepository.delete(product);		
	}

}
