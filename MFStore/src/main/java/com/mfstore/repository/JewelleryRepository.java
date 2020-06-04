package com.mfstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mfstore.domain.Jewellery;

	public interface JewelleryRepository extends CrudRepository<Jewellery, Long>{
		
		List<Jewellery> findByProductCategory(String productCategory);
		
		List<Jewellery> findByTitleContaining(String title);

}
