package com.tinyurl.murl.api.url;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tinyurl.murl.api.BaseService;
import com.tinyurl.myurl.dto.url.UrlDTO;
import com.tinyurl.myurl.service.url.UrlService;

@Component
@Path("/api/url")
public class Url extends BaseService {
        
    @Autowired
    UrlService urlService;
    
    @GET
    @Path("/getUrl/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UrlDTO getUsersByOrganization(@Context HttpServletRequest request) throws MalformedURLException {
        
        UrlDTO dto = new UrlDTO();
       
        return dto;
    }

}