package com.samymartins.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samymartins.hrpayroll.entities.Payment;
import com.samymartins.hrpayroll.entities.Worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	private final RestTemplate restTemplate;

	public Payment getPayment(Long workerId, Integer days) {
		
		Worker worker = getWorker(workerId);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	public Worker getWorker(Long workerId) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		return restTemplate.getForObject(workerHost + "/{id}", Worker.class, uriVariables);
	}
	
}
