package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.ecommerce.request.CreateProductRequest;
import com.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ecommerce.exception.productException;
import com.ecommerce.model.Product;
import com.ecommerce.request.CreateProductRequest;
import com.ecommerce.response.ApiResponse;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest req) throws productException{
		
		Product product = productService.CreateProduct(req);
		
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		
	}
	 
	@DeleteMapping("/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws productException{
		
//		System.out.println("delete product controller .... ");
//		String msg=productService.deleteProduct(productId);
//		System.out.println("delete product controller .... msg "+msg);
		
		productService.deleteProduct(productId);
		ApiResponse res=new ApiResponse();
		res.setMessage("product deleted successfully");
		res.setStatus(true);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){
		
		List<Product> products = productService.getAllProduct();
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@PutMapping("/{productId}/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product req,@PathVariable Long productId) throws productException{
		
		Product Product=productService.updateProduct(productId, req);
		
		return new ResponseEntity<Product>(Product,HttpStatus.CREATED);
	}
	
	@PostMapping("/creates")
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] reqs) throws productException{
		
		for(CreateProductRequest product:reqs) {
			productService.CreateProduct(product);
		}
		
		ApiResponse res=new ApiResponse();
		res.setMessage("products created successfully");
		res.setStatus(true);
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}

}
