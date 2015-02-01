package com.tinyurl.myurl.service.url;


import com.tinyurl.myurl.dto.url.ShortenTokenDTO;

public interface ShortenTokenService {

    ShortenTokenDTO findTokenByName(String name);

}
