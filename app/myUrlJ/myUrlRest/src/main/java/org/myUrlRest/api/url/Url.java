package org.myUrlRest.api.url;

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
import org.url.dto.url.UrlDTO;
import org.url.service.url.UrlService;


@Component
@Path("/api/url")
public class Url{
    
    @Autowired
    UrlService urlService;   
    /**
     * Loads the list of users for the current organization (or all)
     * 
     * @param inputStream
     *            the input stream from the request
     * @return the list of users for the current organization (or all)
     * @throws MalformedURLException
     */
    @GET
    @Path("/getTinyUrl/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UrlDTO getUsersByOrganization(@Context HttpServletRequest request) throws MalformedURLException {
        UrlDTO dto = new UrlDTO();
        return dto;
    }


}