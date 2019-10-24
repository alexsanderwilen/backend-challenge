package com.invillia.acme.service;

import com.invillia.acme.model.Customer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {


    void sendOrderConfimationEmail(Customer customer);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Customer customer, String newPass);
}
