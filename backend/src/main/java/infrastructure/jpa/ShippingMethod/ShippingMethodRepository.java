package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ShippingMethodRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<ShippingMethodEntity> all() {
        return em.createQuery("SELECT c FROM ShippingMethodEntity c", ShippingMethodEntity.class).getResultList();
    }
}
