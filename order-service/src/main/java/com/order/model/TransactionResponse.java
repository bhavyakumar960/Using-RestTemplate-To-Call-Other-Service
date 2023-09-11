package com.order.model;
import com.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private Order order;
    private double amount;
    private String transactionId;
    private String message;
}