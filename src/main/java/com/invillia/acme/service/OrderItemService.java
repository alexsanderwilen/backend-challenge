package com.invillia.acme.service;

import com.invillia.acme.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItems(Long orderId);

    OrderItem getOrderItem(Long orderId,Long id);

    void saveOrderItem(OrderItem orderItem );

    void updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(Long orderId, Long id);

    void deleteOrderItems(Long orderId);

}
