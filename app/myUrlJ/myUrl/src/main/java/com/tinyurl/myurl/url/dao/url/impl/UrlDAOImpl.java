package com.tinyurl.myurl.url.dao.url.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.tinyurl.myurl.dao.url.UrlDAO;
import com.tinyurl.myurl.model.url.Url;
import com.tinyurl.myurl.url.dao.JpaDAO;

@Repository("urlDAO")
public class UrlDAOImpl extends JpaDAO<Url>  implements UrlDAO {

    private static final Logger LOGGER = Logger.getLogger(UrlDAOImpl.class.getCanonicalName());
    private static final String ERROR_GET_URLS = "Error loading urls";
    private static final String NO_URL_ERROR = "Attempted to find non-existent url with for url with id {0}";
    
    @Override
    protected Class<Url> getEntityClass() {
        return Url.class;
    }
    
    @Override
    public Url updateUrl(Url url) {
        try {
            saveEntity(url);

        } catch (javax.persistence.EntityExistsException e) {
            LOGGER.log(Level.WARNING, NO_URL_ERROR, new Object[] { e });
        }
        return url;
    }

    /*not currently used*/
    @Override
    public String validateUrl(Url url) {
        boolean isNew = url.getId() == null;
        Query q = entityManager.createQuery("select count(u) from Url u where " + (isNew ? "" : "u.id <> :id and ") + "u.url = :url");

        if (!isNew) {
            q.setParameter("id", url.getId());
        }

        q.setParameter("url", url.getUrl());

        try {
            if ((long) q.getSingleResult() != 0) {
                return "E_DUPLICATE_URL";
            }
        } catch (NoResultException nre) {
            LOGGER.log(Level.WARNING, ERROR_GET_URLS, nre);
        }

        return null;
    }

    @Override
    public Url findUrlById(Long id) {
        return findById(id);
    }


    @Override
    public String findUrlByToken(Long tokenId) {
       String result = null;
       Query q = entityManager.createQuery("select u.url from Url u inner join u.token t where u.id = t.url.id and t.id = :id");
       q.setParameter("id", tokenId);
       try {
           result = (String) q.getSingleResult();
       }catch (NoResultException nre) {
           LOGGER.log(Level.WARNING, ERROR_GET_URLS, nre);
       }
       
       return result;
    }

    @Override
    public String getCurrentToken(Long id) {
        String result = null;
        Query q = entityManager.createQuery("select t.token from Url u inner join u.token t where u.id = t.url.id and u.id = :id order by t.created desc").setMaxResults(1);
        q.setParameter("id", id);
        try {
            result = (String) q.getSingleResult();
        }catch (NoResultException nre) {
            LOGGER.log(Level.WARNING, ERROR_GET_URLS, nre);
        }
        
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Url findUrlByName(String url) {
        List<Url> result = null;
        Query q = entityManager.createQuery("select u from Url u where u.url = :url");
        q.setParameter("url", url);
        try {
            result = q.getResultList();
        }catch (NoResultException nre) {
            LOGGER.log(Level.WARNING, ERROR_GET_URLS, nre);
        }
        
        return CollectionUtils.isEmpty(result ) ? null : result.get(0);
    }
  

}
