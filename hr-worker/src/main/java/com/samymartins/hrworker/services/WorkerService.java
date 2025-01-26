package com.samymartins.hrworker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samymartins.hrworker.entities.Worker;
import com.samymartins.hrworker.exception.WorkerException;
import com.samymartins.hrworker.repositories.WorkerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerService {
	
	private final WorkerRepository workerRepository;
	
	public List<Worker> findAll(){
		log.info("Retornando todos os trabalhadores");
		return workerRepository.findAll();
	}
	
	public Worker findById(Long id) {
		log.info("Trabalhador pelo id: {}", id);
		return workerRepository.findById(id).orElseThrow(() -> 
			new WorkerException("Trabalhador nao encontrado com id: " + id));
	}

}
