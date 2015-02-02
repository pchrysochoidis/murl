/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tinyurl.myurl.service.url;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

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

import com.tinyurl.myurl.dto.url.UrlDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class UrlServiceTest {

    @Autowired
    UrlService urlService;

    public UrlServiceTest() {
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
      
        UrlDTO dto = new UrlDTO();
       
        dto.setUrl("http://www.facebook.com");
        dto.setCreated(Date.valueOf("2015-02-02"));
        dto.setModified(Date.valueOf("2015-02-02"));
        dto = urlService.updateUrl(dto);
        
        assertEquals(dto.getUrl(), "http://www.facebook.com");
   }
    
    @Transactional
    @Rollback
    @Test
    public void testFindUrlByToken() {
      
       String tokenText = "e0d61fb8";
       
       assertEquals(urlService.findUrlByToken(tokenText), "http://www.uom.gr");
   }


  
}
