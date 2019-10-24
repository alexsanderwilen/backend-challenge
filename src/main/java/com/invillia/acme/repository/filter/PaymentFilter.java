package com.invillia.acme.repository.filter;

import java.util.Date;

public class PaymentFilter {

    private String status;

    private String creditCardNumber;

    private Date paymentDateFrom;

    private Date paymentDateTo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getPaymentDateFrom() {
        return paymentDateFrom;
    }

    public void setPaymentDateFrom(Date paymentDateFrom) {
        this.paymentDateFrom = paymentDateFrom;
    }

    public Date getPaymentDateTo() {
        return paymentDateTo;
    }

    public void setPaymentDateTo(Date paymentDateTo) {
        this.paymentDateTo = paymentDateTo;
    }
}
