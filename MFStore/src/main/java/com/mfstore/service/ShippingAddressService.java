package com.mfstore.service;

import com.mfstore.domain.ShippingAddress;
import com.mfstore.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
