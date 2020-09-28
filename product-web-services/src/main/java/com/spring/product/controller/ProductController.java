package com.spring.product.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.product.exception.ResourceNotFoundException;
import com.spring.product.model.Product;
import com.spring.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController
{
	@Autowired
	private ProductService productService;
	
//-------------------------------------------------------------------------SAVE PRODUCT INFORMATION---------------------------------

	@PostMapping()
	public ResponseEntity<?> saveProduct(@RequestBody Product product)
	{
		Product saveProduct = productService.saveProduct(product);
		
		URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(saveProduct.getId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
//-------------------------------------------------------------------------GET PRODUCTS INFORMATIONS---------------------------------
	
	@GetMapping						
	public List<Product> getProducts()
	{
		return productService.getProducts();
	}
	
//-------------------------------------------------------------------------GET PRODUCT INFORMATION-----------------------------------	
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Integer id)
	{
		return productService.getProduct(id);
	}
	
//-------------------------------------------------------------------------DELETE PRODUCT INFORMATION---------------------------------	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id)
	{
		Product product = productService.deleteProduct(id);
		
		if(ObjectUtils.isEmpty(product))
			throw new ResourceNotFoundException("Product", "Id", id);
		
		return ResponseEntity.noContent().build();
	}
	
//--------------------------------------------------------------------------END------------------------------------------------------
}
