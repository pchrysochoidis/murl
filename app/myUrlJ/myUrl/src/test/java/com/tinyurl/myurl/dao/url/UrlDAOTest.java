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

import com.tinyurl.myurl.model.url.Url;

/**
 *
 * @author Karen.Molony
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class UrlDAOTest {

    @Autowired
    UrlDAO urlDAO;

    public UrlDAOTest() {
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
        Url url = new Url();
        String urlText = "http://www.uom.gr";
        
        url.setUrl(urlText);
        urlDAO.updateUrl(url);
        
        url = urlDAO.findUrlByName(url.getUrl());
        assertEquals(url.getUrl(), urlText);
    }
    
    
   
}
