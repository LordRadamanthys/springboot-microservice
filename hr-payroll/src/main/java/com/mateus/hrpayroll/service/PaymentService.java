package com.mateus.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mateus.hrpayroll.client.WorkerClient;
import com.mateus.hrpayroll.entities.Payment;
import com.mateus.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerClient workerClient;

	public Payment getPayment(long workerId, int days) {

		Worker worker = workerClient.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
