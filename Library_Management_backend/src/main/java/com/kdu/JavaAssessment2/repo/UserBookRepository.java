package com.kdu.JavaAssessment2.repo;

import com.kdu.JavaAssessment2.entity.User;
import com.kdu.JavaAssessment2.entity.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook,Long> {
    @Query("select u.book_id.bookId from UserBook u where u.user_id = ?1")
    List<Long> findByUser_id(User user_id);

    @Transactional
    @Modifying
    @Query("delete from UserBook u where u.user_id = ?1")
    int deleteByUser_id(User user_id);

}
