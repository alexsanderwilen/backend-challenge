package com.invillia.acme.resource;

import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.model.Order;
import com.invillia.acme.service.OrderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderResource {

    @Autowired
    private OrderServiceImpl orderService;

    @ApiOperation(value="Returns the list of orders present in the database.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @ApiOperation(value="Returns a order based on the given id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable("id") Long id){
        return orderService.getOrder(id);
    }

    @ApiOperation(value="Receives data from a order, performs the registration of this information.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(@RequestBody Order order ){
        orderService.saveOrder(order);
    }

    @ApiOperation(value="Receives data from a order, updates this information.")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
    }

    @ApiOperation(value="Deletes a order based on the id entered.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }
}
