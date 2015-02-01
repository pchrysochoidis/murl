package com.tinyurl.myurl.url.dao.url.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;





import com.tinyurl.myurl.dao.url.UrlDAO;
import com.tinyurl.myurl.model.url.Url;
import com.tinyurl.myurl.url.dao.JpaDAO;

@Repository("urlDAOImpl")
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

    @Override
    public String validateUrl(Url url) {
        boolean isNew = url.getId() == null;
        Query q = entityManager.createQuery("select count(u) from Url u where " + (isNew ? "" : "u.id <> :id and ") + "u.name = :name");

        if (!isNew) {
            q.setParameter("id", url.getId());
        }

        q.setParameter("name", url.getUrl());

        try {
            if ((long) q.getSingleResult() != 0) {
                return "E_BUILDING_DUPLICATE_NAME";
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

    

}
