package com.kdu.JavaAssessment2.repo;

import com.kdu.JavaAssessment2.entity.User;
import com.kdu.JavaAssessment2.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.userName = ?1")
    User findByUserName(String userName);

}
