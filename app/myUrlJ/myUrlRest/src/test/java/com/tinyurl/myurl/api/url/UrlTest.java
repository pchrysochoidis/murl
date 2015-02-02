/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tinyurl.myurl.api.url;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.SpringLifecycleListener;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tinyurl.murl.api.url.Url;

/**
 *
 * @author Karen.Molony
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class UrlTest extends JerseyTest {
    
    public UrlTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
   
    @Override
    protected Application configure() {
        ResourceConfig rc = new ResourceConfig(Url.class)
        .register(SpringLifecycleListener.class)
        .register(RequestContextFilter.class)
        .register(SpringJUnit4ClassRunner.class);
        rc.property("contextConfigLocation", "classpath:testContext.xml");
        return rc;
    }    

    @Test
    public void testSaveUrl() throws JsonProcessingException {

        class Temp {
            private String url = "http://www.twitter.gr";

            @SuppressWarnings("unused")
            public String getUrl() {
                return url;
            }
        }

        Temp dto = new Temp();
        Response rs = target("/api/url/saveUrl/").request(MediaType.APPLICATION_JSON).post(Entity.json(dto));

        String response = rs.readEntity(String.class);

        assertNotNull(response);
        
    }
    
    @Test
    public void testGetToken() throws JsonProcessingException {

        class Temp {
            private String token = "e0d61fb8";

            @SuppressWarnings("unused")
            public String getToken() {
                return token;
            }
        }

        Temp dto = new Temp();
        Response rs = target("/api/url/getToken/").request(MediaType.APPLICATION_JSON).post(Entity.json(dto));

        String response = rs.readEntity(String.class);

        assertNotNull(response);
        
    }
 
  
}
