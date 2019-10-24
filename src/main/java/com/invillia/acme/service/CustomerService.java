package com.invillia.acme.service;

import com.invillia.acme.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    Customer getCustomerEmail(String email);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    String activeCustomer(Long id);
}
