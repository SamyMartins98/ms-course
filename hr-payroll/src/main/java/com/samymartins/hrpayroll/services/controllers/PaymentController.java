package com.samymartins.hrpayroll.services.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samymartins.hrpayroll.entities.Payment;
import com.samymartins.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	@GetMapping(value = "/{workerId}/{days}")
	public ResponseEntity<Payment> getPayments(@PathVariable Long workerId, @PathVariable Integer days) {
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
		
	}

}
