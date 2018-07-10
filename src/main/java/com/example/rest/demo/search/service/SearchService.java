package com.example.rest.demo.search.service;

import com.example.rest.demo.search.entity.SearchResponseVo;
import org.springframework.http.ResponseEntity;

public interface SearchService {
  ResponseEntity<SearchResponseVo> search(String query);
}
