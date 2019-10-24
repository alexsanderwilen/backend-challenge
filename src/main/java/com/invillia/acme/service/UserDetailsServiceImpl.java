package com.invillia.acme.service;

import com.invillia.acme.model.Customer;
import com.invillia.acme.repository.CustomerRepository;
import com.invillia.acme.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);

        if (customer == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(customer.getId(), customer.getEmail(), customer.getPassword(), customer.getProfiles());
    }
}