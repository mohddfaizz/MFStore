package com.mfstore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfstore.domain.Jewellery;
import com.mfstore.domain.User;
import com.mfstore.service.JewelleryService;
import com.mfstore.service.UserService;

@Controller
public class SearchController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JewelleryService jewelleryService;

	@RequestMapping("/searchByProductCategory")
	public String searchByCategory(
			@RequestParam("productCategory") String productCategory,
			Model model, Principal principal
			){
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String classActiveCategory = "active"+productCategory;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		classActiveCategory = classActiveCategory.replaceAll("&", "");
		model.addAttribute(classActiveCategory, true);
		
		List<Jewellery> jewelleryList = jewelleryService.findByProductCategory(productCategory);
		
		if (jewelleryList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "jewellerylist";
		}
		
		model.addAttribute("jewelleryList", jewelleryList);
		
		return "jewellerylist";
	}
	
	@RequestMapping("/searchJewellery")
	public String searchJewellery(
			@ModelAttribute("keyword") String keyword,
			Principal principal, Model model
			) {
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		List<Jewellery> jewelleryList = jewelleryService.blurrySearch(keyword);
		
		if (jewelleryList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "jewellerylist";
		}
		
		model.addAttribute("jewelleryList", jewelleryList);
		
		return "jewellerylist";
	}
}
