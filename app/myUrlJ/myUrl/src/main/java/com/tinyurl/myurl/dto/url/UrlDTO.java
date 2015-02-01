package com.tinyurl.myurl.dto.url;

import java.sql.Date;
import java.util.List;

import com.tinyurl.myurl.model.url.ShortenToken;
import com.tinyurl.myurl.model.url.Url;

/*data transfer object*/
/*this is the object that will be transfered through web service to front end*/

public class UrlDTO {
    
    private Long id;
    private String url;
    private Date created;
    private Date modified;
    private Long[] tokens;
    
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
    
    public Long[] getTokens() {
        return tokens;
    }
    public void setTokens(Long[] tokens) {
        this.tokens = tokens;
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

    private static Long[] mapTokens(List<ShortenToken> tokens) {
        if (tokens == null) {
            return new Long[0];
        }

        int n = tokens.size();
        Long[] result = new Long[n];

        for (int i = 0; i < n; i++) {
            result[i] = tokens.get(i).getId();
        }

        return result;
    }

}
