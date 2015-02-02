/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tinyurl.myurl.service.url;

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

import com.tinyurl.myurl.dto.url.ShortenTokenDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class ShortenTokenServiceTest {

    @Autowired
    ShortenTokenService tokenService;

    public ShortenTokenServiceTest() {
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
    public void testFindTokenByName() {
      
        ShortenTokenDTO dto = new ShortenTokenDTO();
       
        dto.setToken("e0d61fb8");
        
        dto = tokenService.findTokenByName(dto.getToken());
        
        assertEquals(dto.getToken(), "e0d61fb8");
   }

  
}
