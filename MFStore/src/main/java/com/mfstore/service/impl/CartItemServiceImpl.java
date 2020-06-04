package com.mfstore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfstore.domain.CartItem;
import com.mfstore.domain.Jewellery;
import com.mfstore.domain.JewelleryToCartItem;
import com.mfstore.domain.Order;
import com.mfstore.domain.ShoppingCart;
import com.mfstore.domain.User;
import com.mfstore.repository.CartItemRepository;
import com.mfstore.repository.JewelleryToCartItemRepository;
import com.mfstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private JewelleryToCartItemRepository jewelleryToCartItemRepository;
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getJewellery().getPrice()).multiply(new BigDecimal(cartItem.getQty()));
		
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}
	
	public CartItem addJewelleryToCartItem(Jewellery jewellery, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItemList) {
			if(jewellery.getId() == cartItem.getJewellery().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(jewellery.getPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setJewellery(jewellery);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(jewellery.getPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
		
		JewelleryToCartItem jewelleryToCartItem = new JewelleryToCartItem();
		jewelleryToCartItem.setJewellery(jewellery);
		jewelleryToCartItem.setCartItem(cartItem);
		jewelleryToCartItemRepository.save(jewelleryToCartItem);
		
		return cartItem;
	}
	
	public CartItem findById(Long id) {
		return cartItemRepository.findById(id).get();
	}
	
	public void removeCartItem(CartItem cartItem) {
		jewelleryToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
	}
	
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	public List<CartItem> findByOrder(Order order) {
		return cartItemRepository.findByOrder(order);
	}


}
