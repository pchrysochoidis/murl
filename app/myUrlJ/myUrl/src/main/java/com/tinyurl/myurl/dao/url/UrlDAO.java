package com.tinyurl.myurl.dao.url;

import java.util.List;

import com.tinyurl.myurl.model.url.Url;

/*UrlDAO access layer for url object*/
/*this class will have metods like select, update etc URL object*/
public interface UrlDAO {

    Url updateUrl(Url url);

    String validateUrl(Url url);

    Url findUrlById(Long id);

    List<String> findUrlByToken(Long tokenId);

}
