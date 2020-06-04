package com.mfstore.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfstore.domain.BillingAddress;
import com.mfstore.domain.CartItem;
import com.mfstore.domain.Jewellery;
import com.mfstore.domain.Order;
import com.mfstore.domain.Payment;
import com.mfstore.domain.ShippingAddress;
import com.mfstore.domain.ShoppingCart;
import com.mfstore.domain.User;
import com.mfstore.repository.OrderRepository;
import com.mfstore.service.CartItemService;
import com.mfstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	public synchronized Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem : cartItemList) {
			Jewellery jewellery = cartItem.getJewellery();
			cartItem.setOrder(order);
			jewellery.setInStockNumber(jewellery.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	public Order findOne(Long id) {
		return orderRepository.findById(id).get();
	}

}
