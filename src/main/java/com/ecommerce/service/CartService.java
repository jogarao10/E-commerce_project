package com.ecommerce.service;

import com.ecommerce.exception.productException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.User;
import com.ecommerce.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws productException;
	
	public Cart findUserCart(Long userId);

}
