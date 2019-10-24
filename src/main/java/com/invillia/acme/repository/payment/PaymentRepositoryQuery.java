package com.invillia.acme.repository.payment;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.filter.PaymentFilter;

import java.util.List;


public interface PaymentRepositoryQuery {
    List<Payment> filter(PaymentFilter paymentFilter);
}
