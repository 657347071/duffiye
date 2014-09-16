package com.duffiye.dao.impl.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.duffiye.dao.entity.IEntity;

public abstract class AbstractDAO<T extends IEntity<Long>> extends GenericDAO<T> {
	
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
  
}
