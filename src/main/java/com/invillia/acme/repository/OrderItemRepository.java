package com.invillia.acme.repository;

import com.invillia.acme.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query(value = "SELECT ORDERITEM_ID, DESCRIPTION, QUANTITY, UNIT_PRICE, NULL ORDERITEM_ID_ORDER FROM ORDER_ITEM WHERE ORDERITEM_ID_ORDER = ?1", nativeQuery = true)
    List<OrderItem> getOrderItemsByOrderStore(Long orderID);

    @Query(value = "SELECT ORDERITEM_ID, DESCRIPTION, QUANTITY, UNIT_PRICE, NULL ORDERITEM_ID_ORDER FROM ORDER_ITEM WHERE ORDERITEM_ID_ORDER = ?1 AND ORDERITEM_ID = ?2", nativeQuery = true)
    OrderItem getOrderItemsByOrderStoreAndId(Long orderID, Long id);

}
