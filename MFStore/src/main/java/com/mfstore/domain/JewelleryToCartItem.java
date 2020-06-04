package com.mfstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JewelleryToCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="jewellery_id")
	private Jewellery jewellery;
	
	@ManyToOne
	@JoinColumn(name="cart_item_id")
	private CartItem cartItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Jewellery getJewellery() {
		return jewellery;
	}

	public void setJewellery(Jewellery jewellery) {
		this.jewellery = jewellery;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	
	
}
