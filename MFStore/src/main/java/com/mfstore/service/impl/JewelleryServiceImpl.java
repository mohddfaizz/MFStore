package com.mfstore.service.impl;
	
	
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfstore.domain.Jewellery;
import com.mfstore.repository.JewelleryRepository;
import com.mfstore.service.JewelleryService;

	@Service
	public class JewelleryServiceImpl implements JewelleryService{
		
		@Autowired
		private JewelleryRepository jewelleryRepository;
		
		public List<Jewellery> findAll() {
			List<Jewellery> jewelleryList = (List<Jewellery>) jewelleryRepository.findAll();
			List<Jewellery> activeJewelleryList = new ArrayList<>();
			
			for (Jewellery jewellery: jewelleryList) {
				if(jewellery.isActive()) {
					activeJewelleryList.add(jewellery);
				}
			}
			
			return activeJewelleryList;
		}
		
		public Jewellery findOne(Long id) {
			return jewelleryRepository.findById(id).get();
		}

		public List<Jewellery> findByProductCategory(String productCategory){
			List<Jewellery> jewelleryList = jewelleryRepository.findByProductCategory(productCategory);
			
			List<Jewellery> activeJewelleryList = new ArrayList<>();
			
			for (Jewellery jewellery: jewelleryList) {
				if(jewellery.isActive()) {
					activeJewelleryList.add(jewellery);
				}
			}
			
			return activeJewelleryList;
		}
		
		public List<Jewellery> blurrySearch(String title) {
			List<Jewellery> jewelleryList = jewelleryRepository.findByTitleContaining(title);
	List<Jewellery> activeJewelleryList = new ArrayList<>();
			
			for (Jewellery jewellery: jewelleryList) {
				if(jewellery.isActive()) {
					activeJewelleryList.add(jewellery);
				}
			}
			
			return activeJewelleryList;
		}
}

