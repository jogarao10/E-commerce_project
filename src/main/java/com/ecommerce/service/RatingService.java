package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.productException;
import com.ecommerce.model.Rating;
import com.ecommerce.model.User;
import com.ecommerce.request.RatingRequest;

public interface RatingService {
	
	public Rating createRating(RatingRequest req,User user) throws productException;
	
	public List<Rating> getProductsRating(Long productId);

}
