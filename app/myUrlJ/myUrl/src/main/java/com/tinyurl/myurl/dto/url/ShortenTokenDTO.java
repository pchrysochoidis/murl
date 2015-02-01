package com.tinyurl.myurl.dto.url;

import java.sql.Date;

import com.tinyurl.myurl.model.url.ShortenToken;

public class ShortenTokenDTO {
    
    private Long id;
    private String token;
    private Date created;
    private Date modified;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
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
    
    public static ShortenTokenDTO map(ShortenToken token) {
        ShortenTokenDTO dto = new ShortenTokenDTO();

        if (token != null) {
            dto.setId(token.getId());
            dto.setToken(token.getToken());
            dto.setCreated(token.getCreated());
            dto.setModified(token.getModified());
            
        }

        return dto;
    }

}
