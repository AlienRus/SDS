package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PositionRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<PositionEntity> all() {
        return em.createQuery("SELECT c FROM PositionEntity c", PositionEntity.class).getResultList();
    }
}
