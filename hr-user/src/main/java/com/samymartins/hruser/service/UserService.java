package com.samymartins.hruser.service;

import org.springframework.stereotype.Service;

import com.samymartins.hruser.entities.User;
import com.samymartins.hruser.exception.UserException;
import com.samymartins.hruser.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> 
		new UserException("Usuario nao encontrado com id: " + id));
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
