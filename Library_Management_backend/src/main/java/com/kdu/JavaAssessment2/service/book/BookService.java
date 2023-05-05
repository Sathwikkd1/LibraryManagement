package com.kdu.JavaAssessment2.service.book;
import com.kdu.JavaAssessment2.entity.*;
import com.kdu.JavaAssessment2.exception.ObjectNotFoundException;
import com.kdu.JavaAssessment2.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Service
public class BookService implements IBookService {
    @Autowired
    TenantRepository tenantRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookCountRepository bookCountRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserBookRepository userBookRepository;

    public ResponseEntity<String> addBooks(Long tenantId, String bookName, String bookCategory, Integer count) {

        Tenant tenant = (Tenant) tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not fetched"));
        ;

        Book book = Book.builder()
                .tenantId(tenant)
                .bookName(bookName)
                .book_category(bookCategory)
                .build();
        bookRepository.save(book);

        BookCount bookCount = BookCount.builder()
                .bookId(book)
                .count(count)
                .build();
        bookCountRepository.save(bookCount);

        return new ResponseEntity<>("Book added successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> getUserBook(List<Long> bookIdList, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("User not got book", HttpStatus.BAD_REQUEST);
        }
        String userNamed = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(userNamed);
        for (Long bookId : bookIdList) {
            BookCount bookCount=bookCountRepository.findByBookId(bookId);
            if(bookCount.getCount()<1){
                throw new RuntimeException("Book count is less than the requirement");
            }

            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new RuntimeException("Book not found"));
            UserBook userBook = UserBook.builder()
                    .user_id(user)
                    .book_id(book)
                    .build();
            userBookRepository.save(userBook);
            bookCountRepository.updateCountByBookId(bookCount.getCount()-1,bookId);
        }
        return new ResponseEntity<>("Books allocated successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> returnBook(){
        String userNamed = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(userNamed);
        List<Long> bookIdList=userBookRepository.findByUser_id(user);
        System.out.println("user name"+user);
        System.out.println("booking ids = "+bookIdList);

        for(Long bookId:bookIdList){
            BookCount bookCount=bookCountRepository.findByBookId(bookId);
            bookCountRepository.updateCountByBookId(bookCount.getCount()+1,bookId);
        }
        userBookRepository.deleteByUser_id(user);
        return new ResponseEntity<>("returned the book successfully",HttpStatus.OK);
    }

    public ResponseEntity<?> getBooksByCategory(String category){
        List<Book> booklist=bookRepository.findByBook_category(category);
        return new ResponseEntity<>(booklist,HttpStatus.OK);
    }
}


