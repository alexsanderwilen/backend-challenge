package com.invillia.acme.service;

import com.invillia.acme.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;


public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfimationEmail(Customer customer) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromCustomer(customer);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromCustomer(Customer customer) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(customer.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Customer successfully registered!: " + customer.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(customer.toString());
        return sm;
    }

    @Override
    public void sendNewPasswordEmail(Customer customer, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(customer, newPass);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Customer customer, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(customer.getEmail());
        sm.setFrom(sender);
        sm.setSubject("New Password Request");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("New password: " + newPass);
        return sm;
    }
}

