package com.mateus.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.hroauth.repository.UserRepository;

import entities.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findByEmail(String email) {
		User user = repository.findByEmail(email).getBody();
		if (user == null) {
			throw new IllegalArgumentException("Email not found");
		}
		return user;
	}
}
