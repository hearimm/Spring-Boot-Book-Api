package com.example.rest.demo.search.entity;

import lombok.Data;

@Data
public class MetaVo {
  int totalCount;
  int pageableCount;
  boolean isEnd;
}
