package com.kdu.JavaAssessment2.repo;

import com.kdu.JavaAssessment2.entity.Book;
import com.kdu.JavaAssessment2.entity.BookCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookCountRepository extends JpaRepository<BookCount,Long> {
    @Query("select b from BookCount b where b.bookId.bookId = ?1")
    BookCount findByBookId(Long bookId);

    @Transactional
    @Modifying
    @Query("update BookCount b set b.count = ?1 where b.bookId.bookId = ?2")
    int updateCountByBookId(Integer count, Long bookId);


}
