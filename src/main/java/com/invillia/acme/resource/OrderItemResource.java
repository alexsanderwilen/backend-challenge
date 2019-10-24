package com.invillia.acme.resource;

import com.invillia.acme.model.OrderItem;
import com.invillia.acme.service.OrderItemServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderItems")
public class OrderItemResource {

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @ApiOperation(value="Returns the list of order items based on the order ID.")
    @GetMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItem> getOrderItems(@PathVariable("orderId") Long orderId){
        return orderItemService.getOrderItems(orderId);
    }

    @ApiOperation(value="Returns an order item based on the order ID and the order item.")
    @GetMapping("/order/item/{orderId}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItem getOrderItem(@PathVariable("orderId") Long orderId, @PathVariable("id") Long id){
        return orderItemService.getOrderItem(orderId, id);
    }

    @ApiOperation(value="Receives data from the order item, performs the registration of this information.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrderItem(@RequestBody OrderItem orderItem ){
        orderItemService.saveOrderItem(orderItem);
    }

    @ApiOperation(value="Receives data from the order item, updates this information.")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderItem(@RequestBody OrderItem orderItem){
        orderItemService.updateOrderItem(orderItem);
    }

    @ApiOperation(value="Deletes an order item based on the order ID and the order item.")
    @DeleteMapping("/order/item/{orderId}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderItem(@PathVariable("orderId") Long orderId, @PathVariable("id") Long id){
        orderItemService.deleteOrderItem(orderId, id);
    }

    @ApiOperation(value="Deletes an order item based on the order ID.")
    @DeleteMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderItems(@PathVariable("orderId") Long orderId){
        orderItemService.deleteOrderItems(orderId);
    }
}
