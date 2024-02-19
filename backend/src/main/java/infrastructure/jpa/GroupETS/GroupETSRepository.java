package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class GroupETSRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<GroupETSEntity> all() {
        return em.createQuery("SELECT c FROM GroupETSEntity c", GroupETSEntity.class).getResultList();
    }
}