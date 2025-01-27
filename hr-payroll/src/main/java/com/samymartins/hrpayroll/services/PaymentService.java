package com.samymartins.hrpayroll.services;

import javax.naming.ServiceUnavailableException;

import org.springframework.stereotype.Service;

import com.samymartins.hrpayroll.entities.Payment;
import com.samymartins.hrpayroll.entities.Worker;
import com.samymartins.hrpayroll.feignclients.WorkerFeignClient;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService {

	private final WorkerFeignClient feignClient;

	public Payment getPayment(Long workerId, Integer days) throws ServiceUnavailableException {
		try {
			Worker worker = getWorker(workerId);
			log.info("Calculo de pagamento para o id: {}", workerId);

			return new Payment(worker.getName(), worker.getDailyIncome(), days);
		} catch (FeignException e) {
			throw new ServiceUnavailableException("Serviço temporariamente indisponível");
		}

	}

	public Worker getWorker(Long workerId) {
		return feignClient.findById(workerId).getBody();
	}

}
