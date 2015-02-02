package com.tinyurl.myurl.service.url.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
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
    
    private Url getUrlFromDTO(UrlDTO dto) {
       
        List<ShortenToken> tokens = new ArrayList<ShortenToken>();
        List<Long> tokenIds = new ArrayList<Long>();
        Url url = urlDAO.findUrlByName(dto.getUrl());
        if (url == null) {
            url = new Url();
        } 

        url.setUrl(dto.getUrl());
        //get tokens for url
        if (dto.getTokens()!= null) {
           for (Long id : dto.getTokens()) {
               ShortenToken token = tokenDAO.findTokenById(id);
               tokens.add(token);
           }
        }
        dto.setTokens(tokenIds);
        url.setToken(tokens);
        return url;
    }

    @Override
    @Transactional
    public UrlDTO updateUrl(UrlDTO dto) {

        Url url = getUrlFromDTO(dto);
       
        url = urlDAO.updateUrl(url);
        dto = UrlDTO.map(url);
        
        shortenUrl(url);

        return dto;
    }
    
    @Override
    @Transactional
    public String getCurrentToken(UrlDTO dto) {
        String currentToken = urlDAO.getCurrentToken(dto.getId());
        
        return currentToken;
    }
    
    
    private ShortenTokenDTO shortenUrl(Url url) {
        List<Long> tokenIds = new ArrayList<Long>();
        ShortenTokenDTO shortenDTO = new ShortenTokenDTO();
        String shorten = getShortenToken(url.getUrl());
        shortenDTO.setToken(shorten);
       
        ShortenToken token = getTokenFromDTO(shortenDTO);
        
        token.setUrl(url);
        shortenDTO = ShortenTokenDTO.map(tokenDAO.updateToken(token));
        
        tokenIds.add(shortenDTO.getId());
      
        return shortenDTO;
        
    }
    
    private String getShortenToken(String url) {
        
        return Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
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

    @Override
    @Transactional
    public String findUrlByToken(String tokenName) {
        ShortenToken token = tokenDAO.findTokenByName(tokenName);
        return urlDAO.findUrlByToken(token.getId());
    }


}