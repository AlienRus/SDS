package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PaymentMethodRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<PaymentMethodEntity> all() {
        return em.createQuery("SELECT c FROM PaymentMethodEntity c", PaymentMethodEntity.class).getResultList();
    }
}
