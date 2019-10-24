package com.invillia.acme.resource;

import com.invillia.acme.model.Customer;
import com.invillia.acme.service.CustomerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerServiceImpl customerService;

    @ApiOperation(value="Returns the list of customers present in the database.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @ApiOperation(value="Returns a customer based on the given id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @ApiOperation(value="Based on customer id, enables customer registration")
    @GetMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String activateCustomer(@PathVariable("id") Long id) {
        return customerService.activeCustomer(id);
    }

    @ApiOperation(value="Receives data from the customer, performs the registration of this information.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @ApiOperation(value="Receives data from the customer, updates this information.")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @ApiOperation(value="Deletes the customer based on the id entered.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }
}