package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
