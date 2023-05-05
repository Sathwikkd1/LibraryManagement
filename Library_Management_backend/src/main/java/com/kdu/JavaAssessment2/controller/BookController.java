package com.kdu.JavaAssessment2.controller;

import com.kdu.JavaAssessment2.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("/get/books")
    public ResponseEntity<?> getBooks(@RequestParam(name = "category") String category){
        return bookService.getBooksByCategory(category);
    }

    @PostMapping("/add/book")
    public ResponseEntity<String> addBooks(@RequestParam(name = "tenant_id") Long tenantId,@RequestParam(name = "book_name") String bookName,@RequestParam(name = "book_category") String bookCategory,@RequestParam(name = "count") Integer count){
        return bookService.addBooks(tenantId,bookName,bookCategory,count);
    }

    @PostMapping("/user/book")
    public ResponseEntity<String> userBook(@Valid @RequestBody List<Long> bookingIdList, BindingResult result){
        return bookService.getUserBook(bookingIdList,result);
    }

    @PostMapping("/return/book")
    public ResponseEntity<String> returnBook(){
        return bookService.returnBook();
    }


}