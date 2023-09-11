package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Payment;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		return paymentService.doPayment(payment);
	}
	
	
}
