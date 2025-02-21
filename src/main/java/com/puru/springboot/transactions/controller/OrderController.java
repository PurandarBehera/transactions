package com.puru.springboot.transactions.controller;

import com.puru.springboot.transactions.dto.OrderRequest;
import com.puru.springboot.transactions.dto.OrderResponse;
import com.puru.springboot.transactions.entity.Order;
import com.puru.springboot.transactions.response.OrderResponsePage;
import com.puru.springboot.transactions.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.placeOrderResponse(orderRequest));
    }

    @GetMapping
    public OrderResponsePage retrieveAllOrders(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "2",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir){
        return orderService.retrieveAllOrders(pageNo,pageSize, sortBy,sortDir);
    }
}
