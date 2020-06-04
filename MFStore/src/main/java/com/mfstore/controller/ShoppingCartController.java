package com.mfstore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfstore.domain.CartItem;
import com.mfstore.domain.Jewellery;
import com.mfstore.domain.ShoppingCart;
import com.mfstore.domain.User;
import com.mfstore.service.CartItemService;
import com.mfstore.service.JewelleryService;
import com.mfstore.service.ShoppingCartService;
import com.mfstore.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private JewelleryService jewelleryService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}

	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("jewellery") Jewellery jewellery,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		jewellery = jewelleryService.findOne(jewellery.getId());
		
		if (Integer.parseInt(qty) > jewellery.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/jewelleryDetail?id="+jewellery.getId();
		}
		
		CartItem cartItem = cartItemService.addJewelleryToCartItem(jewellery, user, Integer.parseInt(qty));
		model.addAttribute("addJewellerySuccess", true);
		
		return "forward:/jewelleryDetail?id="+jewellery.getId();
	}
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(
			@ModelAttribute("id") Long cartItemId,
			@ModelAttribute("qty") int qty
			) {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}
}
