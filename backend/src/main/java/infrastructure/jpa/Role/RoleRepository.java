package com.sds.test.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class RoleRepository {
    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    public List<RoleEntity> all() {
        return em.createQuery("SELECT c FROM RoleEntity c", RoleEntity.class).getResultList();
    }
}
