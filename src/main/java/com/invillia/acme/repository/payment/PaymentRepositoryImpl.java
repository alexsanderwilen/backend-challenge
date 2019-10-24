package com.invillia.acme.repository.payment;


import com.invillia.acme.model.Payment;
import com.invillia.acme.model.Payment_;
import com.invillia.acme.repository.filter.PaymentFilter;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Payment> filter(PaymentFilter paymentFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Payment> criteria = builder.createQuery(Payment.class);
        Root<Payment> root = criteria.from(Payment.class);

        Predicate[] predicates = createConstraints(paymentFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Payment> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] createConstraints(PaymentFilter paymentFilter, CriteriaBuilder builder, Root<Payment> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(paymentFilter.getStatus())) {
            predicates.add(builder.like(
                    builder.lower(root.get(Payment_.STATUS)), "%" + paymentFilter.getStatus().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(paymentFilter.getCreditCardNumber())) {
            predicates.add(builder.equal(
                    builder.lower(root.get(Payment_.CREDIT_CARD_NUMBER)), paymentFilter.getCreditCardNumber().toLowerCase()));
        }

        if (paymentFilter.getPaymentDateFrom() != null) {
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get(Payment_.PAYMENT_DATE), paymentFilter.getPaymentDateFrom()));
        }

        if (paymentFilter.getPaymentDateTo() != null) {
            predicates.add(
                    builder.lessThanOrEqualTo(root.get(Payment_.PAYMENT_DATE), paymentFilter.getPaymentDateTo()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}