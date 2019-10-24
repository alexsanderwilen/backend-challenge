package com.invillia.acme.service;

import com.invillia.acme.exception.OrderNotFoundException;
import com.invillia.acme.exception.RefundExpiredDaysOrder;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.Refund;
import com.invillia.acme.repository.OrderRepository;
import com.invillia.acme.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundRepository refundRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Refund getRefund(Long id) {
        return refundRepository.getOne(id);
    }

    @Override
    public void saveRefund(Refund refund) {

        if(refund.getOrder() == null){
            throw new OrderNotFoundException("Order not informed on refund");
        }

        Order order = orderRepository.getOne(refund.getOrder().getId());

        LocalDate today = LocalDate.now();
        today = today.minusDays(10);

        if(order.getConfirmationDate().isBefore(today)){
            throw new RefundExpiredDaysOrder(today.plusDays(10));
        }

        refund.setOrder(order);
        refundRepository.save(refund);
    }

    @Override
    public void updateRefund(Refund refund) {
        saveRefund(refund);
    }

    @Override
    public void deleteRefund(Long id) {
        refundRepository.deleteById(id);
    }
}
