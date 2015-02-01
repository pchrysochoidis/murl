package com.tinyurl.myurl.url.dao.url.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tinyurl.myurl.dao.url.ShortenTokenDAO;
import com.tinyurl.myurl.model.url.ShortenToken;
import com.tinyurl.myurl.url.dao.JpaDAO;

@Repository("shortenTokenDAOImpl")
public class ShortenTokenDAOImpl extends JpaDAO<ShortenToken> implements ShortenTokenDAO{

    private static final Logger LOGGER = Logger.getLogger(UrlDAOImpl.class.getCanonicalName());
    private static final String ERROR_GET_URLS = "Error loading urls";
    private static final String NO_TOKEN_ERROR = "Attempted to find non-existent token with for url with id {0}";
    
    @Override
    protected Class<ShortenToken> getEntityClass() {
        return ShortenToken.class;
    }
    
    @Override
    public String validateToken(ShortenToken token) {
        boolean isNew = token.getId() == null;
        Query q = entityManager.createQuery("select count(s) from ShortenToken s where " + (isNew ? "" : "s.id <> :id and ") + "s.token = :token");

        if (!isNew) {
            q.setParameter("id", token.getId());
        }

        q.setParameter("token", token.getToken());

        try {
            if ((long) q.getSingleResult() != 0) {
                return "E_DUBLICATE_TOKEN";
            }
        } catch (NoResultException nre) {
            LOGGER.log(Level.WARNING, ERROR_GET_URLS, nre);
        }

        return null;
    }

    @Override
    public ShortenToken findTokenById(Long id) {
        return findById(id);
    }

    @Override
    public ShortenToken updateToken(ShortenToken token) {
        try {
            saveEntity(token);

        } catch (javax.persistence.EntityExistsException e) {
            LOGGER.log(Level.WARNING, NO_TOKEN_ERROR, new Object[] { e });
        }
        return token;
    }

    @Override
    public ShortenToken findTokenByName(String name) {
        ShortenToken result = null;
        Query q = entityManager.createQuery("select s from ShortenToken s where s.token = :token");
        q.setParameter("token", name);
        try {
            result = (ShortenToken) q.getSingleResult();
        }catch (javax.persistence.EntityExistsException e) {
            LOGGER.log(Level.WARNING, NO_TOKEN_ERROR, new Object[] { e });
        }
        return result;
         
    }

}
