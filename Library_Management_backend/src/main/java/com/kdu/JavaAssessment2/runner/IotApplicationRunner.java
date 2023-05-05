package com.kdu.JavaAssessment2.runner;

import com.kdu.JavaAssessment2.repo.UserCredentialsRepository;
import com.kdu.JavaAssessment2.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;

@Component
@Slf4j
public class IotApplicationRunner implements ApplicationRunner{
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

}


//    private String kickstonId;
//    private String deviceUserName;
//    private String devicePassword;
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    @ColumnDefault("CURRENT_TIMESTAMP")
//    private Timestamp manufactureTime;
//    private String manufacturePlace;