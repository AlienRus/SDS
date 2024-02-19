package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StatusRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<StatusEntity> all() {
        return em.createQuery("SELECT c FROM StatusEntity c", StatusEntity.class).getResultList();
    }
}
