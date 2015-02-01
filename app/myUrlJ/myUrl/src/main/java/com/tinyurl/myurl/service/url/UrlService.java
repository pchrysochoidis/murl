package com.tinyurl.myurl.service.url;

import java.util.List;

import com.tinyurl.myurl.dto.url.UrlDTO;

/*service methods*/
/*service will be called by web service */
public interface UrlService {

    String validateUrl(UrlDTO dto);

    UrlDTO updateUrl(UrlDTO dto);

    List<String> findUrlByToken(String tokenName);

}
