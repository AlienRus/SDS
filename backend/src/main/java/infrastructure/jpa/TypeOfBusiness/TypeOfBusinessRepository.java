package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TypeOfBusinessRepository {

    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<TypeOfBusinessEntity> all() {
        return em.createQuery("SELECT c FROM TypeOfBusinessEntity c", TypeOfBusinessEntity.class).getResultList();
    }
}