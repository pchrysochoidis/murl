package com.tinyurl.myurl.dto.url;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.tinyurl.myurl.model.url.ShortenToken;
import com.tinyurl.myurl.model.url.Url;

/*data transfer object*/
/*this is the object that will be transfered through web service to front end*/

public class UrlDTO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1882995142772619914L;

    
    private Long id;
    private String url;
    private Date created;
    private Date modified;
    private List<Long> tokens;
    private String currentToken;
  
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
    
    public List<Long> getTokens() {
        return tokens;
    }
    public void setTokens(List<Long> tokens) {
        this.tokens = tokens;
    }

    public String getCurrentToken() {
        return currentToken;
    }
    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }
    public static UrlDTO map(Url url) {
        UrlDTO dto = new UrlDTO();

        if (url != null) {
            dto.setId(url.getId());
            dto.setUrl(url.getUrl());
            dto.setCreated(url.getCreated());
            dto.setModified(url.getModified());
            
            if (url.getToken()!=null) {
                dto.setTokens(mapTokens(url.getToken()));
            }
        }

        return dto;
    }

    private static List<Long> mapTokens(List<ShortenToken> tokens) {
        if (tokens == null) {
            return new ArrayList<Long>();
        }

        int n = tokens.size();
        List<Long> result =  new ArrayList<Long>();

        for (int i = 0; i < n; i++) {
            result.add(tokens.get(i).getId());
        }

        return result;
    }

}
