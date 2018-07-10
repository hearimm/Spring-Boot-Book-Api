package com.example.rest.demo.search.entity;

import java.util.List;
import lombok.Data;

@Data
public class SearchResponseVo {
  MetaVo meta;
  List<DocumentsVo> documents;
}
