package com.kdu.JavaAssessment2.repo;

import com.kdu.JavaAssessment2.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials,Long> {
    @Query("select u from UserCredentials u where u.userName = ?1")
    UserCredentials findByUserName(String userName);

}
