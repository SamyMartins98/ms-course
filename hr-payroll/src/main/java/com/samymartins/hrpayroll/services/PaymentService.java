package com.samymartins.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.samymartins.hrpayroll.entities.Payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Marcos", 5000.00, days);
	}
	
}
