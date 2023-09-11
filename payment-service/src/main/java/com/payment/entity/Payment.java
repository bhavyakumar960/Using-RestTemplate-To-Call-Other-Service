package com.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_payment")
public class Payment {

	@Id
	@GeneratedValue
	private Integer paymentId;
	private String paymentStatus;
	private String transactionId;
	private Integer orderId;
	private Double amount;
	
}
