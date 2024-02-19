package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class RequestRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<RequestEntity> all() {
        return em.createQuery("SELECT c FROM RequestEntity c", RequestEntity.class).getResultList();
    }
}
