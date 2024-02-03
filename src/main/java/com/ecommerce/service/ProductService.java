package com.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecommerce.exception.productException;
import com.ecommerce.model.Product;
import com.ecommerce.request.CreateProductRequest;


public interface ProductService {
	
	public Product CreateProduct(CreateProductRequest req);
	
	public String deleteProduct(Long productId) throws productException;
	
	public Product updateProduct(Long productId, Product req) throws productException;
	
	public List<Product> getAllProduct();
	
	public Product findProductById(Long id) throws productException;
	
	
	public List<Product> findProductByCategory(String category);
	
	public Page<Product>getAllProduct(String category,List<String>colors,
			List<String>sizes,Integer minPrice, Integer maxPrice,Integer minDisCount,
			String sort,String stock,Integer pageNumber,Integer pageSize);

	

	                                       
	
	
	

}
