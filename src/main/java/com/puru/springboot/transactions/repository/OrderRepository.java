package com.puru.springboot.transactions.repository;

import com.puru.springboot.transactions.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
