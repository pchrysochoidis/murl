package com.tinyurl.myurl.service.url;

import java.util.List;

import com.tinyurl.myurl.dto.url.UrlDTO;

/*service methods*/
/*service will be called by web service */
public interface UrlService {


    UrlDTO updateUrl(UrlDTO dto);

    List<String> findUrlByToken(String tokenName);

    String getCurrentToken(UrlDTO dto);

}
