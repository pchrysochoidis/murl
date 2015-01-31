package com.tinyurl.myurl.model.url;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.tinyurl.myurl.model.BaseEntity;

@Entity
@Table(name = "murl_sorten_token")
public class SortenToken extends BaseEntity {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6221501555938976569L;

    @Column(nullable=false, name ="token")
    @NotEmpty
    String token;
    
    @Column(nullable=false, name ="created")
    Date created;
    
    @Column(nullable=false, name ="modified")
    Date modified;

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

}
