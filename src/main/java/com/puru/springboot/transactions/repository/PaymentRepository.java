package com.puru.springboot.transactions.repository;

import com.puru.springboot.transactions.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
