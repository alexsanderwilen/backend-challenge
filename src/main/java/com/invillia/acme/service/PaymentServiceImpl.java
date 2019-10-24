package com.invillia.acme.service;

import com.invillia.acme.exception.OrderNotFoundException;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.OrderRepository;
import com.invillia.acme.repository.PaymentRepository;
import com.invillia.acme.repository.filter.PaymentFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Payment> filter(PaymentFilter paymentFilter) {
        return paymentRepository.filter(paymentFilter);
    }

    @Override
    public void savePayment(Payment payment) {

        if(payment.getOrder() == null){
            throw new OrderNotFoundException("Order not informed on payment");
        }

        Order order = orderRepository.getOne(payment.getOrder().getId());
        payment.setOrder(order);
        paymentRepository.save(payment);
    }

}
