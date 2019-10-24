package com.invillia.acme.resource;

import com.invillia.acme.model.Refund;
import com.invillia.acme.service.RefundServiceImpl;
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

@RestController
@RequestMapping("refunds")
public class RefundResource {

    @Autowired
    private RefundServiceImpl refundService;

    @ApiOperation(value="Returns a refund based on the given id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Refund getRefund(@PathVariable("id") Long id){
        return refundService.getRefund(id);
    }

    @ApiOperation(value="Receives data from the refund, performs the registration of this information.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRefund(@RequestBody Refund refund){
        refundService.saveRefund(refund);
    }

    @ApiOperation(value="Receives data from the refund, updates this information.")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateRefund(@RequestBody Refund refund){
        refundService.updateRefund(refund);
    }

    @ApiOperation(value="Deletes the refund based on the id entered.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRefund(@PathVariable("id") Long id){
        refundService.deleteRefund(id);
    }
}
