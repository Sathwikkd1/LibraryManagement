package com.kdu.JavaAssessment2.repo;

import com.kdu.JavaAssessment2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book b where b.book_category = ?1")
    List<Book> findByBook_category(String book_category);
}
