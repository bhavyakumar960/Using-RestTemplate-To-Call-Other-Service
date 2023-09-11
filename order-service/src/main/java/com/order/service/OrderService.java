package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.entity.Order;
import com.order.model.PaymentDTO;
import com.order.model.TransactionRequest;
import com.order.model.TransactionResponse;
import com.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String URL = "http://localhost:8081/api/payment/doPayment";
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		
		String message = "";
		
		Order order = orderRepository.saveAndFlush(request.getOrder());
		
		//setting payment object
		PaymentDTO paymentDTO = request.getPayment();
		paymentDTO.setOrderId(order.getId());
		paymentDTO.setAmount(order.getPrice());
		
		//do a rest call to set payment and pass orderId
		PaymentDTO paymentResp = restTemplate.postForObject(URL, request.getPayment(), PaymentDTO.class);
		
		message = paymentResp.getPaymentStatus().equals("success")?"payment successfully done":"some error in payment api, order is set to cart";
		
		return TransactionResponse.builder()
				.order(order)
				.amount(paymentResp.getAmount())
				.transactionId(paymentResp.getTransactionId())
				.message(message)
				.build();
	}
	
}
