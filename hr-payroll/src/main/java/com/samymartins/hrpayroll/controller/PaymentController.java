package com.samymartins.hrpayroll.controller;

import javax.naming.ServiceUnavailableException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samymartins.hrpayroll.entities.Payment;
import com.samymartins.hrpayroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments")
public class PaymentController {

	private final PaymentService paymentService;

	@CircuitBreaker(name = "paymentService", fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days)
			throws ServiceUnavailableException {
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}

	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days, Throwable t) {
		System.out.println("Falha capturada: " + t.getMessage());
		Payment payment = new Payment("Fallback", 200.00, days);
		return ResponseEntity.ok(payment);
	}

}
