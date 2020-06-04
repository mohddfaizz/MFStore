package com.mfstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfstore.domain.UserPayment;
import com.mfstore.repository.UserPaymentRepository;
import com.mfstore.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService{

	@Autowired
	private UserPaymentRepository userPaymentRepository;
		
	public UserPayment findById(Long id) {
		return userPaymentRepository.findById(id).get();
	}
	
	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}
} 
