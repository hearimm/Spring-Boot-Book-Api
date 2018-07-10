package com.example.rest.demo.search.service.impl;

import com.example.rest.demo.search.entity.SearchResponseVo;
import com.example.rest.demo.search.service.SearchService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SearchServiceImpl implements SearchService {
  private static final String API_KEY = "KakaoAK 53a2819975ee9de75382a51193170b03";
  private static final String URL = "https://dapi.kakao.com/v2/search/book";

  public ResponseEntity<SearchResponseVo> search(String query) {
    HttpEntity<?> entity = getHttpEntity();
    String url = getUriString(query);
    return getResponse(entity, url);
  }

  private HttpEntity<?> getHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    headers.set("Authorization", API_KEY);
    return new HttpEntity<>(headers);
  }

  private String getUriString(String query) {
    return UriComponentsBuilder.fromHttpUrl(URL)
        .queryParam("query", query)
        .build(false)
        .toUriString();
  }

  private ResponseEntity<SearchResponseVo> getResponse(HttpEntity<?> entity, String url) {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.exchange(url, HttpMethod.GET, entity, SearchResponseVo.class);
  }
}
