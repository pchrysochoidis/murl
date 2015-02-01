package com.tinyurl.myurl.model.url;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    
    @Column(nullable=false, name ="created")
    Date created;
    
    @Column(nullable=false, name ="modified")
    Date modified;
    
    @OneToMany(fetch = javax.persistence.FetchType.LAZY)
    List<ShortenToken> token;
    
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

    public List<ShortenToken> getToken() {
        return token;
    }

    public void setToken(List<ShortenToken> token) {
        this.token = token;
    }
    
    
}
