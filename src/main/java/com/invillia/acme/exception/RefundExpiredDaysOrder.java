package com.invillia.acme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RefundExpiredDaysOrder extends RuntimeException {
    public RefundExpiredDaysOrder(LocalDate localDate) {
        super("Order date exceeds allowable refund limit. Date refund:" + localDate);
    }
}
