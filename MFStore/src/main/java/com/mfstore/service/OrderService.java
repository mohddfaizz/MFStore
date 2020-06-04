package com.mfstore.service;

import com.mfstore.domain.BillingAddress;
import com.mfstore.domain.Order;
import com.mfstore.domain.Payment;
import com.mfstore.domain.ShippingAddress;
import com.mfstore.domain.ShoppingCart;
import com.mfstore.domain.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user);
	
	Order findOne(Long id);
}
