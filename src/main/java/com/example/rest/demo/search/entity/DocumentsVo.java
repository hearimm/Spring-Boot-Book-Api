package com.example.rest.demo.search.entity;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class DocumentsVo {
  String title;
  String contents;
  String isbn;
  LocalDateTime dateTime;
  List<String> authors;
  String publisher;
  List<String> translators;
  int price;
  int sale_price;
  String sale_yn;
  String category;
  String thumbnail;
  String barcode;
  String ebook_barcode;
  String status;
}
