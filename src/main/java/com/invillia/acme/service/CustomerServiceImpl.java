package com.invillia.acme.service;

import com.invillia.acme.exception.AuthorizationException;
import com.invillia.acme.exception.NoContentException;
import com.invillia.acme.model.Customer;
import com.invillia.acme.model.Store;
import com.invillia.acme.model.enums.Profile;
import com.invillia.acme.repository.CustomerRepository;
import com.invillia.acme.repository.StoreRepository;
import com.invillia.acme.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(Long id) {

        UserSS userSS = UserService.authenticated();

        if (userSS == null || !userSS.hasRole(Profile.ADMIN) && !id.equals(userSS.getId())) {
            throw new AuthorizationException("Access denied");
        }

        Optional<Customer> customer = customerRepository.findById(id);

        if (!customer.isPresent()) {
            throw new NoContentException("Customer not found! Id: " + id + Customer.class.getName());
        }
        return customer.get();
    }

    @Override
    public Customer getCustomerEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));

        if(customer.getStore() == null){
            throw new RuntimeException("Customer must belong to a store.");
        }

        Optional<Store> store = storeRepository.findById(customer.getStore().getId());

        if (!store.isPresent()){

            throw new RuntimeException("Store associated with customer not found.");
        }

        customer.setStore(store.get());
        customerRepository.save(customer);

        try {
            emailService.sendOrderConfimationEmail(customer);
        }catch (Exception e){
            // This try is not to stop execution, the Customer was successfully included what can give error is sending email to the customer;
            // Here I could write a log stating that there was an error sending email to the customer, but as I did not log anywhere ...
        }
    }

    @Override
    public void updateCustomer(Customer customer) {

        Customer c = customerRepository.getOne(customer.getId());
        if (!c.getPassword().equals(customer.getPassword())) {
            customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        }
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public String activeCustomer(Long id) {
        Customer customer = customerRepository.getOne(id);

        if (customer != null) {
            customer.setActive(true);
            updateCustomer(customer);

            return "Registration successfully activated.";
        }
        return "Error activating registration.";
    }
}