package com.mfstore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfstore.domain.CartItem;
import com.mfstore.domain.ShoppingCart;
import com.mfstore.repository.ShoppingCartRepository;
import com.mfstore.service.CartItemService;
import com.mfstore.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal cartTotal = new BigDecimal(0);

		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		for (CartItem cartItem : cartItemList) {
			if (cartItem.getJewellery().getInStockNumber() > 0) {
				cartItemService.updateCartItem(cartItem);
				cartTotal = cartTotal.add(cartItem.getSubtotal());
			}
		}

		shoppingCart.setGrandTotal(cartTotal);

		shoppingCartRepository.save(shoppingCart);

		return shoppingCart;
	}

	public void clearShoppingCart(ShoppingCart shoppingCart) {
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		for (CartItem cartItem : cartItemList) {
			cartItem.setShoppingCart(null);
			cartItemService.save(cartItem);
		}

		shoppingCart.setGrandTotal(new BigDecimal(0));

		shoppingCartRepository.save(shoppingCart);
	}

}
