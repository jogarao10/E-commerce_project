package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.productException;
import com.ecommerce.model.Review;
import com.ecommerce.model.User;
import com.ecommerce.request.ReviewRequest;

public interface ReviewService {
	
	public Review createReview(ReviewRequest req,User user) throws productException;
	
	public List<Review> getAllReview(Long productId);

}
