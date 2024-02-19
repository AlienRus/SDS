package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class SupplySpecialistRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<SupplierEntity> all() {
        return em.createQuery("SELECT c FROM SupplySpecialistEntity c", SupplySpecialistEntity.class).getResultList();
    }
}
