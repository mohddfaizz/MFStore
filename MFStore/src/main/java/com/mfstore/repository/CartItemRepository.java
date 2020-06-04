package com.mfstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mfstore.domain.CartItem;
import com.mfstore.domain.Order;
import com.mfstore.domain.ShoppingCart;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long>{
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	List<CartItem> findByOrder(Order order);
}
