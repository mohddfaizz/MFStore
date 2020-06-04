package com.mfstore.service;

import java.util.List;

import com.mfstore.domain.Jewellery;


public interface JewelleryService {
	
		List<Jewellery> findAll ();
		
		Jewellery findOne(Long id);
		
		List<Jewellery> findByProductCategory(String productCategory);
		
		List<Jewellery> blurrySearch(String title);
}
