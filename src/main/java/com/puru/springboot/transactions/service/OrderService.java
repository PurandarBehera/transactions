package com.puru.springboot.transactions.service;

import com.puru.springboot.transactions.dto.OrderRequest;
import com.puru.springboot.transactions.dto.OrderResponse;
import com.puru.springboot.transactions.entity.Order;
import com.puru.springboot.transactions.entity.Payment;
import com.puru.springboot.transactions.exception.PaymentException;
import com.puru.springboot.transactions.repository.OrderRepository;
import com.puru.springboot.transactions.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(rollbackFor = PaymentException.class)
    public OrderResponse placeOrderResponse(OrderRequest orderRequest){

        Order order = orderRequest.getOrder();

        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        order.setStatus("IN-PROGRESS");
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Success");
        return orderResponse;
    }

}
