package com.samymartins.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.samymartins.hrpayroll.entities.Payment;
import com.samymartins.hrpayroll.entities.Worker;
import com.samymartins.hrpayroll.feignclients.WorkerFeignClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService {
	
	private final WorkerFeignClient feignClient;

	public Payment getPayment(Long workerId, Integer days) {
		
		Worker worker = getWorker(workerId);
		log.info("Calculo de pagamento para o id: {}", workerId);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	public Worker getWorker(Long workerId) {
		return feignClient.findById(workerId).getBody();
	}
	
}
