package com.samymartins.hrworker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samymartins.hrworker.entities.Worker;
import com.samymartins.hrworker.repositories.WorkerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkerService {
	
	private final WorkerRepository workerRepository;
	
	public List<Worker> findAll(){
		return workerRepository.findAll();
	}
	
	public Worker findById(Long id) {
		return workerRepository.findById(id).get();
	}

}
