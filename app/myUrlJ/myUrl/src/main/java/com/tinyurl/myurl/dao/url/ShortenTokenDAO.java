package com.tinyurl.myurl.dao.url;

import com.tinyurl.myurl.model.url.ShortenToken;

public interface ShortenTokenDAO {

    ShortenToken findTokenById(Long id);

    ShortenToken updateToken(ShortenToken token);

    String validateToken(ShortenToken token);

    ShortenToken findTokenByName(String name);

}
