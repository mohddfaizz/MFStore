package com.mfstore.service;

import com.mfstore.domain.Payment;
import com.mfstore.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
