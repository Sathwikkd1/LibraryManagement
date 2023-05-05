package com.kdu.JavaAssessment2.exception;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

@Slf4j
public class UniqueConstraintException extends PersistenceException {
    public UniqueConstraintException(String message){
        super(message);
        log.error("Exception occurred same entries and given for username");
    }
}
