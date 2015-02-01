package com.tinyurl.myurl.model.url;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.tinyurl.myurl.model.BaseEntity;

/*This is the model of table of database*/
/*Use Hibernate annotations*/
@Entity
@Table(name = "murl_url")
public class Url extends BaseEntity{

    /**
     * 
     */
    private static final long serialVersionUID = -8185947053179311251L;   
    @Column(nullable=false, name ="url")
    @NotEmpty
    String url;
    
    @OneToMany(fetch = javax.persistence.FetchType.LAZY,  mappedBy = "url")
    List<ShortenToken> token;
    
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
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ShortenToken> getToken() {
        return token;
    }

    public void setToken(List<ShortenToken> token) {
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
