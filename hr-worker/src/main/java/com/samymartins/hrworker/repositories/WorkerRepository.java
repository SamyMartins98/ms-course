package com.samymartins.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samymartins.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
