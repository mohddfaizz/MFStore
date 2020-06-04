package com.mfstore.service;

import com.mfstore.domain.UserShipping;

public interface UserShippingService {
	UserShipping findById(Long id);
	
	void removeById(Long id);
}
