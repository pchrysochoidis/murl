/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tinyurl.myurl.url.dao;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tinyurl.myurl.model.BaseEntity;

/**
 *
 * @author Karen.Molony
 * @param <E>
 */
public abstract class JpaDAO<E extends BaseEntity> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<E> getEntityClass();

    public void update(E entity) {
        entityManager.persist(entity);
    }

    public void save(E entity) {
        saveEntity(entity);
    }

    protected <T extends BaseEntity> void saveEntity(T entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
    }

    public void delete(E entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        //entityManager.remove(entity);
    }

    public E findById(Long id) {
        return findById(getEntityClass(), id);
    }

    public E merge(E entity) {
        return entityManager.merge(entity);
    }

    protected <T extends BaseEntity> T findById(Class<T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("rawtypes")
    protected List executeQuery(String queryString, Map<String, Object> parameters) {
        Query q = entityManager.createQuery(queryString);
        
        if (!parameters.isEmpty()) {
            for (String k : parameters.keySet()) {
                q.setParameter(k, parameters.get(k));
            }
        }
        
        return q.getResultList();
    }
}
