package com.invillia.acme.service;

import com.invillia.acme.model.Refund;

public interface RefundService {
    Refund getRefund(Long id);

    void saveRefund(Refund refund);

    void updateRefund(Refund refund);

    void deleteRefund(Long id);
}
