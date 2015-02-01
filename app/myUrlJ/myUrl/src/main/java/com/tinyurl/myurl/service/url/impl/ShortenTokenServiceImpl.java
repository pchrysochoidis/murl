package com.tinyurl.myurl.service.url.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyurl.myurl.dao.url.ShortenTokenDAO;
import com.tinyurl.myurl.dto.url.ShortenTokenDTO;
import com.tinyurl.myurl.service.url.ShortenTokenService;

@Service("shortenTokenService")
public class ShortenTokenServiceImpl implements ShortenTokenService {

    @Autowired
    ShortenTokenDAO tokenDAO;
    
    @Override
    public ShortenTokenDTO findTokenByName(String name) {
        return ShortenTokenDTO.map(tokenDAO.findTokenByName(name));
    }

}
