package com.invillia.acme.repository;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.payment.PaymentRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>, PaymentRepositoryQuery {
}
