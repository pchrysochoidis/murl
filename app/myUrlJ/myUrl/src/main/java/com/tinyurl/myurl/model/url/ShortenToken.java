package com.tinyurl.myurl.model.url;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.tinyurl.myurl.model.BaseEntity;

@Entity
@Table(name = "murl_sorten_token")
public class ShortenToken extends BaseEntity {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6221501555938976569L;

    @Column(nullable=false, name ="token")
    @NotEmpty
    String token;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", nullable = false)
    private Date modified;

    @PrePersist
    protected void onCreate() {
        modified = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modified = new Date();
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

}
