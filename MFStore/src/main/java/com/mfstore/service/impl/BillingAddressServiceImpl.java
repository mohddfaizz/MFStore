package com.mfstore.service.impl;

import org.springframework.stereotype.Service;

import com.mfstore.domain.BillingAddress;
import com.mfstore.domain.UserBilling;
import com.mfstore.service.BillingAddressService;

@Service
public class BillingAddressServiceImpl implements BillingAddressService{
	
	public BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress) {
		billingAddress.setBillingAddressName(userBilling.getUserBillingName());
		billingAddress.setBillingAddressStreet1(userBilling.getUserBillingStreet1());
		billingAddress.setBillingAddressStreet2(userBilling.getUserBillingStreet2());
		billingAddress.setBillingAddressCity(userBilling.getUserBillingCity());
		billingAddress.setBillingAddressState(userBilling.getUserBillingState());
		billingAddress.setBillingAddressCountry(userBilling.getUserBillingCountry());
		billingAddress.setBillingAddressZipcode(userBilling.getUserBillingZipcode());
		
		return billingAddress;
	}

}
