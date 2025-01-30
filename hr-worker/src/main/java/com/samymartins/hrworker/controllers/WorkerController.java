package com.samymartins.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samymartins.hrworker.entities.Worker;
import com.samymartins.hrworker.services.WorkerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RefreshScope
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/workers")
public class WorkerController {
	
	@Value("${test.config}")
	private String testConfig; 
	
	private final WorkerService workerService;
	
	@GetMapping("/getConfigs")
	public ResponseEntity<Void> getConfig() {
		log.info("CONFIG = "+ testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(workerService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		return ResponseEntity.ok(workerService.findById(id));
	}

}
