package com.puru.springboot.transactions.dto;

import com.puru.springboot.transactions.entity.Order;
import com.puru.springboot.transactions.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
