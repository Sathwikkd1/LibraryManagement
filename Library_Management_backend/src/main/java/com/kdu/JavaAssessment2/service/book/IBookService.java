package com.kdu.JavaAssessment2.service.book;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IBookService {
    ResponseEntity<String> addBooks(Long tenantId, String bookName, String bookCategory,Integer count);
    ResponseEntity<String> getUserBook(List<Long> bookIdList, BindingResult result);
    public ResponseEntity<String> returnBook();
    public ResponseEntity<?> getBooksByCategory(String category);

    }
