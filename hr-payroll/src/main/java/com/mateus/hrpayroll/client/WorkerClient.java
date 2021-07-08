package com.mateus.hrpayroll.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mateus.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker",  path = "/workers")
public interface WorkerClient {

	@GetMapping("/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
