/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tinyurl.myurl.dao.url;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tinyurl.myurl.model.url.ShortenToken;

/**
 *
 * @author Karen.Molony
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class ShortenTokenDAOTest {

    @Autowired
    ShortenTokenDAO tokenDAO;

    public ShortenTokenDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Transactional
    @Rollback
    @Test
    public void testSaveUrl() {
        ShortenToken token = new ShortenToken();
        String tokenText = "fTXfdfsd";
        
        token.setToken(tokenText);
        tokenDAO.updateToken(token);
        
        token = tokenDAO.findTokenByName(tokenText);
        assertEquals(token.getToken(), tokenText);
    }
   
    @Transactional
    @Rollback
    @Test
    public void testValidateToken() {
        ShortenToken token = new ShortenToken(); 
        
        token.setToken("e0d61fb8");
        
        assertEquals("E_DUBLICATE_TOKEN", tokenDAO.validateToken(token));

        token.setToken("X");

        assertEquals(null, tokenDAO.validateToken(token));

        token.setId(1L);

        assertEquals(null, tokenDAO.validateToken(token));
    }
    
    @Transactional
    @Rollback
    @Test
    public void testFindTokenById() {
        Long id = 1L;
        String tokenText = "e0d61fb8";
        
        ShortenToken token = tokenDAO.findTokenById(id);
        
        assertEquals(token.getToken(), tokenText);

    }
    
    @Transactional
    @Rollback
    @Test
    public void testFindTokenByName() {
        Long id = 1L;
        String tokenText = "e0d61fb8";
        
        ShortenToken token = tokenDAO.findTokenByName(tokenText);
        
        assertEquals(token.getId(), id);

    }
}
