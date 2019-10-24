package com.invillia.acme.service;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getOrderItems(Long orderId) {
        return orderItemRepository.getOrderItemsByOrderStore(orderId);
    }

    @Override
    public OrderItem getOrderItem(Long orderId, Long id) {
        return orderItemRepository.getOrderItemsByOrderStoreAndId(orderId, id);
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long orderId, Long id) {
        Order order = orderService.getOrder(orderId);
        OrderItem orderItem =  (OrderItem) order.getOrderItems().stream().filter(item -> item.getId().equals(id));
        orderItemRepository.delete(orderItem);
    }

    @Override
    public void deleteOrderItems(Long orderId) {
        Order order = orderService.getOrder(orderId);
        orderItemRepository.deleteAll(order.getOrderItems());
    }
}
