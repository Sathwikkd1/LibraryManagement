package com.kdu.JavaAssessment2.exception;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.criteria.CriteriaBuilder;
@Slf4j
public class InvalidObjectInput extends RuntimeException{
    public InvalidObjectInput(String message){
        super(message);
        log.error("Invalid input given");
    }
}
