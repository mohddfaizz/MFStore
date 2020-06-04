package com.mfstore.service;

import com.mfstore.domain.BillingAddress;
import com.mfstore.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
