package com.mateus.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.hrworker.entities.Worker;
import com.mateus.hrworker.service.WorkerService;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {

	@Autowired
	private WorkerService service;
	
	@Value("${test.config}")
	private String testeConfig;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/config")
	public ResponseEntity<Void> config() {
		System.out.println("CONFIG "+testeConfig);
		return ResponseEntity.noContent().build();
	}

}
