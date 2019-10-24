package com.invillia.acme.service;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.filter.PaymentFilter;

import java.util.List;

public interface PaymentService {
    List<Payment> filter(PaymentFilter paymentFilter);

    void savePayment(Payment payment);
}
