package com.mateus.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.hrworker.entities.Worker;
import com.mateus.hrworker.repository.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	WorkerRepository repository;

	public List<Worker> findAll() {
		List<Worker> list = repository.findAll();
		return list;
	}

	public Worker findById(Long id) {
		Worker obj = repository.findById(id).get();
		return obj;
	}
}
