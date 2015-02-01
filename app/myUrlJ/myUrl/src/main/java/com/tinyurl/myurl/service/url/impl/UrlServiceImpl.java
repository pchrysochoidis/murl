package com.tinyurl.myurl.service.url.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyurl.myurl.dao.url.ShortenTokenDAO;
import com.tinyurl.myurl.dao.url.UrlDAO;
import com.tinyurl.myurl.dto.url.ShortenTokenDTO;
import com.tinyurl.myurl.dto.url.UrlDTO;
import com.tinyurl.myurl.model.url.ShortenToken;
import com.tinyurl.myurl.model.url.Url;
import com.tinyurl.myurl.service.url.UrlService;

@Service("urlService")
public class UrlServiceImpl implements UrlService{
    
    @Autowired
    UrlDAO urlDAO;
    
    @Autowired
    ShortenTokenDAO tokenDAO;
    
    @Override
    @Transactional
    public String validateUrl(UrlDTO dto) {
        Url url = getUrlFromDTO(dto);

        return urlDAO.validateUrl(url);
    }

    private Url getUrlFromDTO(UrlDTO dto) {
        Url url = null;

        if (dto.getId() == null) {
            url = new Url();
        } else {
            url = urlDAO.findUrlById(dto.getId());
        }

        url.setUrl(dto.getUrl());
       
        return url;
    }

    @Override
    public UrlDTO updateUrl(UrlDTO dto) {
        Url url = getUrlFromDTO(dto);

        dto = UrlDTO.map(urlDAO.updateUrl(url));
        
        shortenUrl(dto);
        
        dto = UrlDTO.map(urlDAO.updateUrl(url));
        return dto;
    }
    
    
    private ShortenTokenDTO shortenUrl(UrlDTO dto) {
        List<Long> tokenIds = new ArrayList<Long>();
        ShortenTokenDTO shortenDTO = new ShortenTokenDTO();
        shortenDTO.setToken("TxnxBe");
       
        ShortenToken token = getTokenFromDTO(shortenDTO);
        shortenDTO = ShortenTokenDTO.map(tokenDAO.updateToken(token));
        
        tokenIds.add(shortenDTO.getId());
        dto.setTokens(tokenIds);
        return shortenDTO;
        
    }

    private ShortenToken getTokenFromDTO(ShortenTokenDTO shortenDTO) {
        ShortenToken token = null;

        if (shortenDTO.getId() == null) {
            token = new ShortenToken();
        } else {
            token = tokenDAO.findTokenById(shortenDTO.getId());
        }

        token.setToken(shortenDTO.getToken());
       
        return token;
    }


}
