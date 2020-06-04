package com.mfstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mfstore.domain.CartItem;
import com.mfstore.domain.JewelleryToCartItem;

@Transactional
public interface JewelleryToCartItemRepository extends CrudRepository<JewelleryToCartItem, Long> {
	void deleteByCartItem(CartItem cartItem);
}
