package com.duffiye.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.duffiye.dao.entity.IdEntity;

public abstract class AbstractDAO<T extends IdEntity> extends GenericDAO<T> {
	
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
  
}
