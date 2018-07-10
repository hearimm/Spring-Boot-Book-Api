package com.example.rest.demo.search.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.rest.demo.AppConfig;
import com.example.rest.demo.search.entity.SearchResponseVo;
import com.example.rest.demo.search.service.SearchService;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@TestPropertySource(locations = "classpath:application.properties")
public class SearchServiceImplTest {

  @Autowired SearchService searchServiceService;

  @Test
  public void service() {
    ResponseEntity<SearchResponseVo> response = searchServiceService.search("클린 코드");
    assertThat(
        response
            .getBody()
            .getDocuments()
            .stream()
            .map(x -> x.getTitle())
            .collect(Collectors.joining(",")),
        is(
            "클린 코드,클린 코드(CLEAN CODE),레거시 코드를 클린 코드로 누구나 쉽게, 리팩토링,클린 코드를 위한 테스트 주도 개발,레거시 코드를 클린 코드로 누구나 쉽게, 리팩토링 - Hanbit eBook Realtime 78,클린 소프트웨어,Effective Unit Testing(개발자를 위한 단위 테스트)(한국어판),유지보수 가능한 코딩의 기술 자바편,코드 그린: 뜨겁고 평평하고 붐비는 세계,클린 코더"));
    System.out.println(response.toString());
  }
}
