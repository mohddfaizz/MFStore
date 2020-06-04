package com.mfstore.service;

import java.util.List;

import com.mfstore.domain.CartItem;
import com.mfstore.domain.Jewellery;
import com.mfstore.domain.Order;
import com.mfstore.domain.ShoppingCart;
import com.mfstore.domain.User;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addJewelleryToCartItem(Jewellery jewellery, User user, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);
}
