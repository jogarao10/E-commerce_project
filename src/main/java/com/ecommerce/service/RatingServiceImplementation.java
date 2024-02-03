package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.productException;
import com.ecommerce.model.Product;
import com.ecommerce.model.Rating;
import com.ecommerce.model.User;
import com.ecommerce.repository.RatingRepository;
import com.ecommerce.request.RatingRequest;


@Service
public class RatingServiceImplementation implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private ProductService productService;

	@Override
	public Rating createRating(RatingRequest req, User user) throws productException {

		Product product=productService.findProductById(req.getProductId());
		
		Rating rating=new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatAt(LocalDateTime.now());
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}
	
	
	
}
