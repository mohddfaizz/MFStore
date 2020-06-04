package com.mfstore.service;

import com.mfstore.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);
	
	void removeById(Long id);
}
