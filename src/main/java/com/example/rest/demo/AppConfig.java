package com.example.rest.demo;

import com.example.rest.demo.search.service.SearchService;
import com.example.rest.demo.search.service.impl.SearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  static SearchService searchService() {
    return new SearchServiceImpl();
  }
}
