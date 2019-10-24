package com.invillia.acme.service;

import com.invillia.acme.model.Order;
import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order getOrder(Long id);

    void saveOrder(Order order );

    void updateOrder(Order order);

    void deleteOrder(Long id);
}
