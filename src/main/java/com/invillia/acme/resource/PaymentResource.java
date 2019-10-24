package com.invillia.acme.resource;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.filter.PaymentFilter;
import com.invillia.acme.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value="Returns a list of payments according to the given parameters.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> search(PaymentFilter paymentFilter) {
        return paymentService.filter(paymentFilter);
    }

    @ApiOperation(value="Receives data from a payment, performs the registration of this information.")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void savePayment(@RequestBody Payment payment) {
        paymentService.savePayment(payment);
    }
}
